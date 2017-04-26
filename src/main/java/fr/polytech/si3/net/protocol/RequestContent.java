package fr.polytech.si3.net.protocol;

import java.io.Serializable;

/**
 * Created by alexh on 26/04/2017.
 */
public class RequestContent<AnyType extends Serializable> implements Serializable {
    private Type type;
    private AnyType[] args;

    public RequestContent(Type type, AnyType... args) {
        this.type = type;
        this.args = args;
    }
}
