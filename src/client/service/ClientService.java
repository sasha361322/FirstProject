package client.service;

import client.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by sasha on 12.09.2016.
 */
public class ClientService {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addClient(Client client){
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.persist(client);
        session.getTransaction().commit();
    }
    public void updateClient(Client client){
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.update(client);
        session.getTransaction().commit();
    }
    public void removeClient(int id){
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        Client client = (Client)session.load(Client.class, new Integer(id));
        if (client!=null)
           session.delete(client);
        session.getTransaction().commit();
    }
    public Client getClientById(int id){
        Session session=this.sessionFactory.openSession();
        session.beginTransaction();
        Client client=(Client)session.load(Client.class, id);
        session.getTransaction().commit();
        return client;
    }
    public List<Client> listClients() {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        List<Client> result = session.createQuery("from Client").list();
        session.getTransaction().commit();
        return result;
    }
}
