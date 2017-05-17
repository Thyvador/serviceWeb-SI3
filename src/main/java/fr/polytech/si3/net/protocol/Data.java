package fr.polytech.si3.net.protocol;

import fr.polytech.si3.net.protocol.Idea;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Data extends Remote{

    boolean add(Idea idea) throws RemoteException;
    List<Idea> list() throws RemoteException;
    boolean participate(Idea idea) throws RemoteException;
    List<String> listParticipants(Idea idea) throws RemoteException;

    boolean delete(Idea idea) throws RemoteException;
    boolean edit(Idea idea, Idea newIdea) throws RemoteException;
}
