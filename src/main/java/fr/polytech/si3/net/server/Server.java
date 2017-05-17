package fr.polytech.si3.net.server;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

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
