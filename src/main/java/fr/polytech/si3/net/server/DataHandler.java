package fr.polytech.si3.net.server;

import fr.polytech.si3.net.protocol.Idea;

import java.util.ArrayList;
import java.util.List;

public class DataHandler implements Data {

    private static DataHandler instance;
    private List<Idea> ideas;

    private DataHandler() {
        this.ideas = new ArrayList<>();
    }

    public static DataHandler getInstance() {
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
        return ideas;
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

    public boolean listeEmpty() {
        return ideas.isEmpty();
    }
}
