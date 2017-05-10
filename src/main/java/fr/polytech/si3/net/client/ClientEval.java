package fr.polytech.si3.net.client;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Johann Mortara on 10/05/2017.
 */
public class ClientEval {

    Socket socket = new Socket();
    OutputStream os;
    InputStream is;

    public ClientEval() {
    }

    public void connect(String hostname, int port) throws IOException {
        socket.connect(new InetSocketAddress(hostname, port));
    }

    public void sendRequest(String request) throws IOException {
        os = new DataOutputStream(socket.getOutputStream());
        os.write(request.getBytes());
    }

    public String receiveRequest() throws IOException, ClassNotFoundException {
        is = new DataInputStream(socket.getInputStream());
        BufferedReader d = new BufferedReader(new InputStreamReader(is));
        return d.readLine();
    }

    public void closeConnection() throws IOException {
        os.close();
        is.close();
        socket.close();
    }

}
