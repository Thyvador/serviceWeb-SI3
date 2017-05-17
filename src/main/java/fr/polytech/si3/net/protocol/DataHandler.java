package fr.polytech.si3.net.server;

import fr.polytech.si3.net.protocol.Idea;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class DataHandler extends UnicastRemoteObject implements Data {

    private List<Idea> ideas;

    public DataHandler() throws RemoteException {
        super();
        this.ideas = new ArrayList<>();
    }

    @Override
    public boolean add(Idea idea) throws RemoteException{
        boolean tmp = ideas.add(idea);
        System.out.println(tmp);
        return tmp;
    }

    @Override
    public List<Idea> list() throws RemoteException {
        System.out.println(ideas);
        return ideas;
    }

    @Override
    public boolean participate(Idea idea) throws RemoteException {
        return false;
    }

    @Override
    public List<String> listParticipants(Idea idea) throws RemoteException {
        return null;
    }

    @Override
    public boolean delete(Idea idea) throws RemoteException {
        return false;
    }

    @Override
    public boolean edit(Idea idea, Idea newIdea) throws RemoteException {
        return false;
    }

    public boolean listeEmpty() throws RemoteException {
        return ideas.isEmpty();
    }
}
