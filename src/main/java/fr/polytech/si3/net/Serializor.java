package fr.polytech.si3.net;

import fr.polytech.si3.net.protocol.RequestContent;

import java.io.*;

/**
 * Created by user on 26/04/2017.
 */
public class Serializor<T extends Serializable> {

    public Serializor() {

    }

    public void  Serialize(T obj, OutputStream outputStream) throws IOException {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
    }

    public Object Deserialize(InputStream inputStream) throws IOException {
        try {
            return new ObjectInputStream(inputStream).readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
