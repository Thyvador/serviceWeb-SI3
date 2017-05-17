package fr.polytech.si3.net.server;

import fr.polytech.si3.net.exception.InvalidArgumentSizeException;
import fr.polytech.si3.net.exception.InvallidArgumentException;
import fr.polytech.si3.net.protocol.RequestContent;
import fr.polytech.si3.net.protocol.Type;
import fr.polytech.si3.net.server.request.AddRequest;
import fr.polytech.si3.net.server.request.ListRequest;
import fr.polytech.si3.net.server.request.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexh on 26/04/2017.
 */
public class Server {
    private int portNumber;
    private Map<Type, Request> requestMap;

    public Server(int portNumber) {
        this.portNumber = portNumber;
        this.requestMap = new HashMap<>();
        try {
            requestMap.put(Type.ADD, new AddRequest());
            requestMap.put(Type.LIST, new ListRequest());
        } catch (InvalidArgumentSizeException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException {
        ServerSocket serverSocket = new ServerSocket(portNumber);
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> {
                    System.out.println(clientSocket.getInetAddress() + " : connected");
                    try {
                        while(clientSocket.isConnected()){
                            ObjectOutput output = new ObjectOutputStream(clientSocket.getOutputStream());
                            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
                            RequestContent requestContent = (RequestContent) ois.readObject();
                            System.out.println("Received: "+requestContent);

                            Request request = requestMap.get(requestContent.type);
                            request.execute(requestContent.args);
                            System.out.println("Sent: "+request.getResponse());
//                            System.out.println("    "+request.getResponse());
                            output.writeObject(request.getResponse());
                        }
                    } catch (ClassNotFoundException | InvallidArgumentException | InvalidArgumentSizeException | IOException e) {
                        System.out.println(clientSocket.isConnected());
                        e.printStackTrace();
                    }
    
                }).run();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        try {
            new Server(6666).run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
