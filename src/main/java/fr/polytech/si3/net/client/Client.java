package fr.polytech.si3.net.client;

import fr.polytech.si3.net.protocol.RequestContent;
import fr.polytech.si3.net.protocol.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Johann on 26/04/2017.
 */
public class Client {

    Socket socket;
    ObjectOutputStream oos;
    ObjectInputStream ois;

    public Client() {
        this("10.212.126.224", 6666);
    }

    private Client(String hostname, int port){
        openConnection(hostname, port);
    }

    public void openConnection(String machineMame, int nbPort) {
        try {
            socket = new Socket(machineMame, nbPort);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Response receiveRequest() throws IOException, ClassNotFoundException {
        return ((Response) ois.readObject());
    }

    public void sendRequest(RequestContent request) throws IOException {
        oos.writeObject(request);
    }

    public void closeConnection() throws IOException {
        oos.close();
        ois.close();
        socket.close();
    }

}
