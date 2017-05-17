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
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexh on 26/04/2017.
 */
public class Server {

    public Server() {
        try {
            Data dataHandler = new DataHandler();
            Naming.rebind("DataHandler", dataHandler);

        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException {


    }

    public static void main(String[] args) {
        Server server = new Server();
    }
}
