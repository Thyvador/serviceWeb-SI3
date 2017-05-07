package fr.polytech.si3.net.client;

import fr.polytech.si3.net.protocol.Idea;
import fr.polytech.si3.net.protocol.RequestContent;
import fr.polytech.si3.net.protocol.Response;
import fr.polytech.si3.net.protocol.Type;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by user on 03/05/2017.
 */
public class MainClient {
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.connect("localhost", 6666);
            ArrayList<String> strings = new ArrayList<>();
            strings.add("JAVAFX");
            Idea idea = new Idea("Saucisse", "saucisse", "salut je suis une desciption", strings, strings);
            client.send(new RequestContent<>(Type.ADD, idea));
            Response response = client.receiveResponse();
            System.out.println(response.isStatus());
            client.send(new RequestContent<>(Type.LIST));
            response = client.receiveResponse();
            System.out.println(response.getData());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
