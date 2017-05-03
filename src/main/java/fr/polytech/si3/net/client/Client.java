package fr.polytech.si3.net.client;

import fr.polytech.si3.net.protocol.RequestContent;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

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
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(obj);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendTo(String address, int port, RequestContent obj) {
        InetSocketAddress endpoint = new InetSocketAddress(address, port);
        try {
            socket.connect(endpoint);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(obj);
            System.out.println("sent " + obj);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
