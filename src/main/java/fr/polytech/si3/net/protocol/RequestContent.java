package fr.polytech.si3.net.protocol;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alexh on 26/04/2017.
 */
public class RequestContent<AnyType extends Serializable> implements Serializable {
    public Type type;
    public List<AnyType> args;

    public RequestContent(Type type, List<AnyType> args) {
        this.type = type;
        this.args = args;
    }
}
