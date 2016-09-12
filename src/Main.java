import entity.Client;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import service.ClientService;

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


    public static void main(final String[] args) throws Exception {
        ClientService clientService = new ClientService();
        clientService.setSessionFactory(ourSessionFactory);
        List<Client> clients = clientService.listProfession();
        for (Client client:clients){
            System.out.println(client+"\n\n");
        }
        System.out.println("\n\n\n\n"+clientService.getClientById(1).getBirthday());
    }
}
