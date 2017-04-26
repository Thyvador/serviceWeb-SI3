package fr.polytech.si3.net.protocol;

import java.io.Serializable;

/**
 * Created by alexh on 26/04/2017.
 */
public class RequestContent implements Serializable {
    private Type type;
    private String[] args;

    public RequestContent(Type type, String... args) {
        this.type = type;
        this.args = args;
    }
}
