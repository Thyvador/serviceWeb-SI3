package fr.polytech.si3.net.rmi;

import fr.polytech.si3.net.protocol.Type;
import fr.polytech.si3.net.server.data.DataHandler;
import fr.polytech.si3.net.server.request.AddHandler;
import fr.polytech.si3.net.server.request.GetListHandler;
import fr.polytech.si3.net.server.request.RequestHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
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
        try {
            LocateRegistry.createRegistry(1099);
            if (System.getSecurityManager() == null) System.setSecurityManager(new RMISecurityManager());
            IdeaHandler ideaHandler = new IdeaHandler();
            String url = "rmi://10.212.119.244/testRMI";
            System.out.println("Enregistrement de l'objet avec l'url : " + url);
            Naming.rebind(url, ideaHandler);
            System.out.println("Serveur lancé");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        while (true) {
//        }
    }

    public void closeConnection() throws IOException {
        oos.close();
        ois.close();
    }
}
