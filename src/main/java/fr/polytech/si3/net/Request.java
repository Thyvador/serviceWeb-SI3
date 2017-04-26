package fr.polytech.si3.net;

/**
 * Created by user on 26/04/2017.
 */
public abstract class Request {
    protected String[] args;
    public Request(String... args) {
        this.args=args;
    }
    public abstract void execute();
}
