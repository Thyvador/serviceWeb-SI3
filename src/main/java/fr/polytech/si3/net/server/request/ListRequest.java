package fr.polytech.si3.net.server.request;

import com.sun.javaws.exceptions.InvalidArgumentException;
import fr.polytech.si3.net.Exception.InvalidArgumentSizeException;
import fr.polytech.si3.net.protocol.Response;
import fr.polytech.si3.net.protocol.Type;
import fr.polytech.si3.net.server.DataHandler;

import java.io.Serializable;

/**
 * Created by alexh on 26/04/2017.
 */
public class ListRequest extends Request {
    public ListRequest() throws InvalidArgumentSizeException {
        super(Type.LIST);
    }

    @Override
    public void execute(String... args) throws InvalidArgumentException {
        super.execute(args);
        DataHandler dataHandler = DataHandler.getInstance();
        if (dataHandler.listeEmpty()){
            response = new Response<>(false);
            throw new InvalidArgumentException(args);
        }
        else {
            response = new Response<>(true, (Serializable[]) dataHandler.list().toArray());
        }
    }
}
