package fr.polytech.si3.net.rmi;

import fr.polytech.si3.net.protocol.Idea;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by user on 17/05/2017.
 */
public interface Protocole extends Remote {

    public void add(Idea idea) throws RemoteException;
    public List<Idea> list() throws RemoteException;

}
