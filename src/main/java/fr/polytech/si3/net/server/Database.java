package fr.polytech.si3.net.server;

import fr.polytech.si3.net.Idea;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 26/04/2017.
 */
public class Database {

    List<Idea> ideas;

    private static Database ourInstance = new Database();

    public static Database getInstance() {
        return ourInstance;
    }

    private Database() {
        ideas = new ArrayList <>();
    }

    public List <Idea> getIdeas() {
        return ideas;
    }
}
