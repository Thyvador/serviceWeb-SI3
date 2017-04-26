package fr.polytech.si3.net;

import java.io.Serializable;

/**
 * Created by user on 26/04/2017.
 */
public abstract class Request implements Serializable{

    protected String[] args;

    public Request(String... args) {
        this.args = args;
    }

    public abstract void execute();

}
