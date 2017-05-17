package fr.polytech.si3.net.client;

import fr.polytech.si3.net.Serializor;
import fr.polytech.si3.net.protocol.RequestContent;
import fr.polytech.si3.net.protocol.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by user on 03/05/2017.
 */
public class Client {
    Socket socket = new Socket();
    private int port = 6666;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void connect(String address, int port) throws IOException {
        InetSocketAddress endpoint = new InetSocketAddress(address, port);
        socket.connect(endpoint);
    }

    public void send(RequestContent obj) {
        try {
            new Serializor<RequestContent>().Serialize(obj, socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendTo(String address, int port, RequestContent obj) {
        try {
            connect(address, port);
            send(obj);
            close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Response receiveResponse() {
        try {
            System.out.println("lol");
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            return ((Response) objectInputStream.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void close() throws IOException {
        socket.close();
    }
}
