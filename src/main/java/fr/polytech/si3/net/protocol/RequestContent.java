package fr.polytech.si3.net.protocol;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by alexh on 26/04/2017.
 */
public class RequestContent<AnyType extends Serializable> implements Serializable {
    public Type type;
    public AnyType[] args;

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
