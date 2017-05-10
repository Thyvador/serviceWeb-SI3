package fr.polytech.si3.net.client;

import fr.polytech.si3.net.protocol.RequestContent;
import fr.polytech.si3.net.protocol.Response;
import fr.polytech.si3.net.protocol.Type;

import java.io.IOException;

/**
 * Created by user on 03/05/2017.
 */
public class LaunchClientEval {

    static String addRequest = "{" +
            "\"request\": \"add\"," +
            "\"parameters\": {" +
            "\"title\":\"my great idea\"," +
            "\"content\":\"actually the best idea of the world\"," +
            "\"author\":\"josué\"," +
            "\"contact\":\"mail-perso@etu.unice.fr\"" +
            "}" +
            "}\n" +
            "END\n";

    static String listRequest = "{" +
            "\"request\": \"list\"," +
            "\"parameters\": {}" +
            "}\n" +
            "END\n";

    static String joinRequest = "{" +
            "\"request\": join," +
            "\"parameters\": {" +
            "\"id\"=\"paul@salut.fr\"," +
            "\"title\"=\"fin du monde\"" +
            "}" +
            "}\n" +
            "END\n";

    static String groupRequest = "{" +
            "\"request\": \"group\"," +
            "\"parameters\": {" +
            "\"title\":\"end of the world\"" +
            "}" +
            "}\n" +
            "END\n";

    public static void main(String[] args) {
        ClientEval client = new ClientEval();
        try {
            client.connect("10.212.119.138", 9999);
            client.sendRequest(listRequest);
            System.out.println("Request sent.");
            System.out.println(client.receiveRequest());
            client.closeConnection();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
