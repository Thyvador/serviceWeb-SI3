package fr.polytech.si3.net.protocol;

import java.io.Serializable;

/**
 * The type of the request.
 */
public enum Type implements Serializable{
    ADD(1),
    LIST(0),
    PARTCIPATE(1),
    LISTPART(0),
    DELETE(1),
    EDIT(2);

    /**
     * The number of arguments of the request content.
     */
    public int argc;

    Type(int i) {
        argc = i;
    }
}
