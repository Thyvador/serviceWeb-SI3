package fr.polytech.si3.net.client;

import fr.polytech.si3.net.protocol.RequestContent;
import fr.polytech.si3.net.protocol.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Johann on 26/04/2017.
 */
public class Client {

    Socket socket = new Socket();
    ObjectOutputStream oos;
    ObjectInputStream ois;

    public Client() {
    }

    public void connect(String hostname, int port) throws IOException {
        socket.connect(new InetSocketAddress(hostname, port));
    }

    public void sendRequest(RequestContent request) throws IOException {
        oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(request);
    }

    public Response receiveRequest() throws IOException, ClassNotFoundException {
        ois = new ObjectInputStream(socket.getInputStream());
        return ((Response) ois.readObject());
    }

    public void closeConnection() throws IOException {
        oos.close();
        ois.close();
        socket.close();
    }

}
