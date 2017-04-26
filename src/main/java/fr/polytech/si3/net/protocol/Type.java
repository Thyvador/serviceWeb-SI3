package fr.polytech.si3.net;

/**
 * Created by alexh on 26/04/2017.
 */
public enum Type {
    ADD(5),
    LIST(0);

    int argc;

    Type(int i) {
        argc = i;
    }
}
