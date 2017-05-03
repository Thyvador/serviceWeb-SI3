package fr.polytech.si3.net.server;

import fr.polytech.si3.net.Idea;

import java.util.List;

/**
 * Created by alexh on 26/04/2017.
 */
public class DataHandler implements Data {

    private DataHandler instance;
    private List<Idea> ideas;

    private DataHandler() {
        this.instance = instance;
    }

    public DataHandler getInstance() {
        if (instance == null)
            instance = new DataHandler();
        return instance;
    }

    @Override
    public boolean add(Idea idea) {
        return ideas.add(idea);
    }

    @Override
    public List<Idea> list() {
        return null;
    }

    @Override
    public boolean participate(Idea idea) {
        return false;
    }

    @Override
    public List<String> listParticipants(Idea idea) {
        return null;
    }

    @Override
    public boolean delete(Idea idea) {
        return false;
    }

    @Override
    public boolean edit(Idea idea, Idea newIdea) {
        return false;
    }
}
