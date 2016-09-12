import entity.Client;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

/**
 * Created by sasha on 12.09.2016.
 */
public class Main {
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    private List<Client> listProfession() {
        Session session = getSession();
        session.beginTransaction();
        List<Client> result = session.createQuery("from Client").list();
        session.getTransaction().commit();
        return result;
    }
    public static void main(final String[] args) throws Exception {
        Main main = new Main();
        List<Client> clients = main.listProfession();
        for (Client client:clients){
            System.out.println(client.getName());
        }
    }
}
