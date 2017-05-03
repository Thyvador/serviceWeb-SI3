package fr.polytech.si3.net.server.request;

import com.sun.javaws.exceptions.InvalidArgumentException;
import fr.polytech.si3.net.Exception.InvalidArgumentSizeException;
import fr.polytech.si3.net.protocol.Response;
import fr.polytech.si3.net.protocol.Type;

public abstract class Request {

    private Type type;
    protected String[] args;
    protected Response response;

    public Request(Type type) throws InvalidArgumentSizeException {
        if (args.length != type.argc){
            throw new InvalidArgumentSizeException();
        }
        this.type = type;
    }

    public void execute(String... args) throws InvalidArgumentException {
        this.args = args;
    }

    public Response getResponse() {
        return response;
    }
}
