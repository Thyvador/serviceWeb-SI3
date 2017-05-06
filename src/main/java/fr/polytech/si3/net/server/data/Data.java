package fr.polytech.si3.net.server.data;

import fr.polytech.si3.net.Idea;

import java.util.List;

public interface Data {

    boolean add(Idea idea);
    List<Idea> list();
    boolean participate(Idea idea);
    List<String> listParticipants(Idea idea);

    boolean delete(Idea idea);
    boolean edit(Idea idea, Idea newIdea);
}