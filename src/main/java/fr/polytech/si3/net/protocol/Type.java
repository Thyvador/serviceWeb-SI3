package fr.polytech.si3.net.protocol;

import java.io.Serializable;

/**
 * Created by alexh on 26/04/2017.
 */
public enum Type implements Serializable{
    ADD(5),
    LIST(0);

    public int argc;

    Type(int i) {
        argc = i;
    }
}
