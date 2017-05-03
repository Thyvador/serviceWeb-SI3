package fr.polytech.si3.net.server.request;

import fr.polytech.si3.net.exception.InvalidArgumentSizeException;
import fr.polytech.si3.net.exception.InvallidArgumentException;
import fr.polytech.si3.net.protocol.Response;
import fr.polytech.si3.net.protocol.Type;
import fr.polytech.si3.net.server.DataHandler;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alexh on 26/04/2017.
 */
public class ListRequest<AnyType extends Serializable> extends Request {
    public ListRequest() throws InvalidArgumentSizeException {
        super(Type.LIST);
    }

    @Override
    public void execute(List args) throws InvallidArgumentException, InvalidArgumentSizeException {
        super.execute(args);
        DataHandler dataHandler = DataHandler.getInstance();
        response = new Response<>(true, dataHandler.list());
    }
    
}
