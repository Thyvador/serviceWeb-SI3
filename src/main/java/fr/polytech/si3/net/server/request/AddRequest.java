package fr.polytech.si3.net.server.request;

import com.sun.javaws.exceptions.InvalidArgumentException;
import fr.polytech.si3.net.Exception.InvalidArgumentSizeException;
import fr.polytech.si3.net.protocol.Type;

/**
 * Created by alexh on 26/04/2017.
 */
public class AddRequest extends Request {


    public AddRequest() throws InvalidArgumentSizeException {
        super(Type.ADD);

    }

    @Override
    public void execute(String... args) throws InvalidArgumentException {
        super.execute(args);
    }
}
