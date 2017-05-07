package fr.polytech.si3.net.protocol;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Request content if the object sent by the client to the server. It represent the content of the request: the type and the arguments.
 */
public class RequestContent<AnyType extends Serializable> implements Serializable {
    /**
     * The type of the request :{"ADD", "LIST", ...}
     */
    public Type type;
    /**
     * The argumnents of the request.
     */
    public AnyType[] args;

    /**
     * Constructor of the request.
     * @param type the type of the request.
     * @param args the arguments of the request.
     */
    public RequestContent(Type type, AnyType... args) {
        this.type = type;
        this.args = args;
    }

    @Override
    public String toString() {
        return "RequestContent{" +
                "type=" + type +
                ", args=" + Arrays.toString(args) +
                '}';
    }
}
