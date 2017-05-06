package fr.polytech.si3.net.server;

import fr.polytech.si3.net.exception.InvalidArgumentException;
import fr.polytech.si3.net.exception.InvalidNumberArgumentException;
import fr.polytech.si3.net.protocol.RequestContent;
import fr.polytech.si3.net.protocol.Type;
import fr.polytech.si3.net.server.data.DataHandler;
import fr.polytech.si3.net.server.request.AddHandler;
import fr.polytech.si3.net.server.request.GetListHandler;
import fr.polytech.si3.net.server.request.RequestHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 26/04/2017.
 */
public class Server {
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private ServerSocket serverSocket;
    private DataHandler dataHandler;

    private Map<Type, RequestHandler> requestMap;

    private int PORT = 6666;


    public Server() {
        dataHandler = new DataHandler();
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        requestMap = new HashMap<>();
        requestMap.put(Type.ADD, new AddHandler(dataHandler));
        requestMap.put(Type.LIST, new GetListHandler(dataHandler));
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }

    public void run() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                Thread clientThread = new Thread(() -> {
                    try {
                        System.out.println("New connection : " + clientSocket.getInetAddress());
                        ois = new ObjectInputStream(clientSocket.getInputStream());
                        oos = new ObjectOutputStream(clientSocket.getOutputStream());
                        RequestContent requestContent = (RequestContent) ois.readObject();
                        RequestHandler requestHandler = requestMap.get(requestContent.type);
                        requestHandler.execute(requestContent);
                        oos.writeObject(requestHandler.response());
                        closeConnection();
                    } catch (IOException | ClassNotFoundException | InvalidArgumentException | InvalidNumberArgumentException e) {
                        e.printStackTrace();
                    }
                });
                clientThread.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeConnection() throws IOException {
        oos.close();
        ois.close();
    }
}
