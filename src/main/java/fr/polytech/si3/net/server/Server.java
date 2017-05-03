package fr.polytech.si3.net.server;

import fr.polytech.si3.net.Idea;
import fr.polytech.si3.net.protocol.RequestContent;
import fr.polytech.si3.net.protocol.Type;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by user on 26/04/2017.
 */
public class Server {
    private ObjectInputStream ois;
//    private ObjectOutputStream oos;
    private ServerSocket serverSocket;

    private Socket clientSocket = null;

    private int PORT = 6666;


    public Server() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openServer() {
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                ois = new ObjectInputStream(clientSocket.getInputStream());
                RequestContent requestContent = (RequestContent) ois.readObject();
                if (requestContent.type.equals(Type.ADD)){
                    Idea idea = (Idea) requestContent.args.get(0);
                    DataHandler dataHandler = new DataHandler();
                    dataHandler.add(idea);
                    System.out.println("Complete");
                }
                closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeConnection() throws IOException {
        ois.close();
        clientSocket.close();
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.openServer();
    }
}
