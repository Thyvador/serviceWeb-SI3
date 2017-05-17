package fr.polytech.si3.net.server.request;

import fr.polytech.si3.net.protocol.Idea;
import fr.polytech.si3.net.exception.InvalidArgumentSizeException;
import fr.polytech.si3.net.exception.InvallidArgumentException;
import fr.polytech.si3.net.protocol.Response;
import fr.polytech.si3.net.protocol.Type;
import fr.polytech.si3.net.server.DataHandler;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by alexh on 26/04/2017.
 */
public class AddRequest extends Request {


    public AddRequest() throws InvalidArgumentSizeException {
        super(Type.ADD);
    }

    @Override
    public void execute(Serializable[] args) throws InvallidArgumentException, InvalidArgumentSizeException {
        super.execute(args);

        DataHandler dataHandler = DataHandler.getInstance();
        if (args[0] instanceof Idea){
            dataHandler.add((Idea) args[0]);
        }else
            throw new InvallidArgumentException();

        response = new Response(true, new ArrayList<>());

    }
}
