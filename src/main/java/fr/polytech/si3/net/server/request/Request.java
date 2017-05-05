package fr.polytech.si3.net.server.request;

import fr.polytech.si3.net.exception.InvalidArgumentSizeException;
import fr.polytech.si3.net.exception.InvallidArgumentException;
import fr.polytech.si3.net.protocol.Response;
import fr.polytech.si3.net.protocol.Type;

import java.io.Serializable;
import java.util.Arrays;

public abstract class Request<AnyType extends Serializable> {

    private Type type;
    protected AnyType[] args;
    protected Response response;

    public Request(Type type) {
        this.type = type;
    }

    public void execute(AnyType... args) throws InvallidArgumentException, InvalidArgumentSizeException {
        if (args.length != type.argc) {
            throw new InvalidArgumentSizeException();
        }
        this.args = args;
    }

    public Response getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "Request{" +
                "type=" + type +
                ", args=" + Arrays.toString(args) +
                ", response=" + response +
                '}';
    }
}
