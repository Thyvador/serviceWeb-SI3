package fr.polytech.si3.net.server.request;

import fr.polytech.si3.net.Idea;
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
public class AddHandler extends RequestHandler {
    public AddHandler(DataHandler dataHandler) {
        super(Type.ADD, dataHandler);
    }

    @Override
    public void execute(RequestContent requestContent) throws InvalidNumberArgumentException, InvalidArgumentException {
        super.execute(requestContent);
        if (validArguments(requestContent)){
            dataHandler.add((Idea) requestContent.args.get(0));
        }
    }

    @Override
    public Response response() {
        Response response = new Response<>(true, Arrays.asList("Request received and processed successfully"));
        System.out.println("Request completed");
        return response;
    }

    public boolean validArguments(RequestContent requestContent) throws InvalidArgumentException {
        if(requestContent.args.get(0) instanceof Idea){
            return true;
        }
        throw new InvalidArgumentException("Argument is not an Idea");
    }
}
