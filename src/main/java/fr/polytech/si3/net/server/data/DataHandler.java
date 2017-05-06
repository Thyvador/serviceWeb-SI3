package fr.polytech.si3.net.server.data;

import fr.polytech.si3.net.Idea;
import fr.polytech.si3.net.server.data.Data;

import java.util.ArrayList;
import java.util.List;

public class DataHandler implements Data {

    public static List<Idea> listIdeas;

    public DataHandler() {
        listIdeas = new ArrayList<>();
    }

    @Override
    public boolean add(Idea idea) {
        return listIdeas.add(idea);
    }

    @Override
    public List<Idea> list() {
        return listIdeas;
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
