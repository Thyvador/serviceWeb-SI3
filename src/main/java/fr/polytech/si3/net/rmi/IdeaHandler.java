package fr.polytech.si3.net.rmi;

import fr.polytech.si3.net.protocol.Idea;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * Created by user on 17/05/2017.
 */
public class IdeaHandler extends UnicastRemoteObject implements Protocole {

    protected IdeaHandler() throws RemoteException {
        super();
    }

    @Override
    public void add(Idea idea) throws RemoteException {
        System.out.println("Idée ajoutée");
    }

    @Override
    public List<Idea> list() throws RemoteException {
        return null;
    }
}
