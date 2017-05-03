package fr.polytech.si3.net.client;

import fr.polytech.si3.net.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Johann on 26/04/2017.
 */
public class Client {

    Socket socket;
    ObjectInputStream ois;
    ObjectOutputStream oos;

    public Client() {
    }

    public void openConnection(String machineMame, int nbPort) {
        try {
            socket = new Socket(machineMame, nbPort);
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receiveRequest() throws IOException, ClassNotFoundException {
        ois.readObject();
    }

    public void sendRequest(Request request) throws IOException {
        oos.writeObject(request);
    }

    private void closeConnection() throws IOException {
        oos.close();
        ois.close();
        socket.close();
    }

}
