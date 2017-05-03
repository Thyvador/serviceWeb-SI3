package fr.polytech.si3.net.server;

import fr.polytech.si3.net.server.request.GetRequest;
import fr.polytech.si3.net.server.request.ListRequest;
import fr.polytech.si3.net.server.request.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexh on 26/04/2017.
 */
public class Server {
    private Map<String, Request> requestMap;

    public Server() {
        this.requestMap = new HashMap<>();
        requestMap.put("GET", new GetRequest());
        requestMap.put("LIST", new ListRequest());
    }
}
