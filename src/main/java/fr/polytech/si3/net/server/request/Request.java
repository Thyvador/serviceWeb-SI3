package fr.polytech.si3.net.server.request;

import fr.polytech.si3.net.exception.InvalidArgumentSizeException;
import fr.polytech.si3.net.exception.InvallidArgumentException;
import fr.polytech.si3.net.protocol.Response;
import fr.polytech.si3.net.protocol.Type;

import java.io.Serializable;
import java.util.List;

public abstract class Request<AnyType extends Serializable> {

    private Type type;
    protected List<AnyType> args;
    protected Response response;

    public Request(Type type) {
        this.type = type;
    }

    public void execute(List<AnyType> args) throws InvallidArgumentException, InvalidArgumentSizeException {
        if (args.size() != type.argc) {
            throw new InvalidArgumentSizeException();
        }
        this.args = args;
    }

    public Response getResponse() {
        return response;
    }
}
