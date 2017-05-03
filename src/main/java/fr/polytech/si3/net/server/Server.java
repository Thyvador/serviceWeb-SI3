package fr.polytech.si3.net.server;

import fr.polytech.si3.net.Exception.InvalidArgumentSizeException;
import fr.polytech.si3.net.protocol.Type;
import fr.polytech.si3.net.server.request.AddRequest;
import fr.polytech.si3.net.server.request.ListRequest;
import fr.polytech.si3.net.server.request.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexh on 26/04/2017.
 */
public class Server {
    private Map<Type, Request> requestMap;

    public Server() {
        this.requestMap = new HashMap<>();
        try {
            requestMap.put(Type.ADD, new AddRequest());
            requestMap.put(Type.LIST, new ListRequest());
        } catch (InvalidArgumentSizeException e) {
            e.printStackTrace();
        }
    }
}
