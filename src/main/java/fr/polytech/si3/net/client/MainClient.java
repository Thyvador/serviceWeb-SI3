package fr.polytech.si3.net.client;

import fr.polytech.si3.net.protocol.RequestContent;
import fr.polytech.si3.net.protocol.Type;

import java.io.IOException;

/**
 * Created by user on 03/05/2017.
 */
public class MainClient {
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.connect("10.212.114.254", 6666);
            client.send(new RequestContent<String>(Type.LIST));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
