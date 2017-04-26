package fr.polytech.si3.net.server.request;

public abstract class Request {

    protected String[] args;

    public Request(String... args) {
        this.args = args;
    }

    public abstract void execute();
}
