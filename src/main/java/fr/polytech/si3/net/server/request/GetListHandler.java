package fr.polytech.si3.net.server.request;

import fr.polytech.si3.net.exception.InvalidArgumentException;
import fr.polytech.si3.net.exception.InvalidNumberArgumentException;
import fr.polytech.si3.net.protocol.RequestContent;
import fr.polytech.si3.net.protocol.Response;
import fr.polytech.si3.net.protocol.Type;
import fr.polytech.si3.net.server.data.DataHandler;

import java.util.Arrays;

/**
 * Created by user on 06/05/2017.
 */
public class GetListHandler extends RequestHandler {
    public GetListHandler(DataHandler dataHandler) {
        super(Type.LIST, dataHandler);
    }

    @Override
    public void execute(RequestContent requestContent) throws InvalidNumberArgumentException, InvalidArgumentException {
        super.execute(requestContent);
    }

    @Override
    public Response response() {
        Response response = new Response<>(true, dataHandler.list());
        System.out.println("Request completed");
        return response;
    }

    @Override
    public boolean validArguments(RequestContent requestContent) throws InvalidArgumentException {
        return true;
    }
}
