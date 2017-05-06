package fr.polytech.si3.net.client;

import fr.polytech.si3.net.Idea;
import fr.polytech.si3.net.protocol.RequestContent;
import fr.polytech.si3.net.protocol.Response;
import fr.polytech.si3.net.protocol.Type;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by user on 03/05/2017.
 */
public class LaunchClient {

    public static void main(String[] args) {
        Response response;
        Client client = new Client();
        try {
            client.connect("localhost", 6666);
//            client.sendRequest(new RequestContent <>(Type.ADD, new Idea("author", "author@mail.com", "description", Arrays.asList("techno1", "techno2"), Arrays.asList("participant1", "participant2"))));
            client.sendRequest(new RequestContent <>(Type.LIST));
            System.out.println("Request sent.");
            while (true){
                if ((response = client.receiveRequest()) != null) break;
            }
            System.out.println(response.getData());
            client.closeConnection();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
