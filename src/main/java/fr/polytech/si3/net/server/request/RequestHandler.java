package fr.polytech.si3.net.server.request;

import fr.polytech.si3.net.exception.InvalidArgumentException;
import fr.polytech.si3.net.exception.InvalidNumberArgumentException;
import fr.polytech.si3.net.protocol.RequestContent;
import fr.polytech.si3.net.protocol.Response;
import fr.polytech.si3.net.protocol.Type;
import fr.polytech.si3.net.server.data.DataHandler;

/**
 * Created by user on 06/05/2017.
 */
public abstract class RequestHandler {
    protected DataHandler dataHandler;
    private Type requestType;

    public RequestHandler(Type requestType, DataHandler dataHandler) {
        this.requestType = requestType;
        this.dataHandler = dataHandler;
    }

    public void execute(RequestContent requestContent) throws InvalidNumberArgumentException, InvalidArgumentException {
        if (requestContent.args.length != requestType.argc) {
            throw new InvalidNumberArgumentException("Arguments list must contains " + requestType.argc + " arguments, found : " + requestContent.args.length);
        }
    }

    public abstract Response response();

    public abstract boolean validArguments(RequestContent requestContent) throws InvalidArgumentException;
}
