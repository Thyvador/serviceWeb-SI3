package fr.polytech.si3.net.server.request;

import com.sun.javaws.exceptions.InvalidArgumentException;
import fr.polytech.si3.net.exception.InvalidArgumentSizeException;
import fr.polytech.si3.net.exception.InvallidArgumentException;
import fr.polytech.si3.net.protocol.Type;

import java.io.Serializable;

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

    }
}
