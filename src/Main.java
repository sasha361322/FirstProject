import client.model.Client;
import client.service.ClientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {


    public static void main(final String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ClientService clientService = (ClientService) context.getBean("clientService");
        List<Client> clients = clientService.listProfession();
        for (Client client:clients){
            System.out.println(client+"\n\n");
        }
        System.out.println("\n\n\n\n"+clientService.getClientById(1).getBirthday());
    }
}
