package fr.polytech.si3.net.protocol;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexh on 26/04/2017.
 */

/**
 * Object representing an Idea
 **/
public class Idea implements Serializable {
    /**
     * Name of the author of the idea
     **/
    private String author;
    /**
     * Mail of the author of the idea
     **/
    private String mail;
    /**
     * Textual description of the idea
     **/
    private String description;
    /**
     * List of strings representing the technologies used by the idea
     **/
    private ArrayList<String> technos;
    /**
     * List of strings corresponding to the idea
     **/
    private ArrayList<String> participants;
    
    /**
     * Constructs an idea
     **/
    public Idea(String author, String mail, String description, List<String> technos, List<String> participants) {
        this.author = author;
        this.mail = mail;
        this.description = description;
        this.technos = new ArrayList<>();
        this.technos.addAll(technos);
        this.participants = new ArrayList<>();
        this.participants.addAll(participants);
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getMail() {
        return mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void addTechno(String techno) {
        this.technos.add(techno);
    }
    
    public void addParticipant(String participant) {
        this.participants.add(participant);
    }
    
    @Override
    public String toString() {
        return "Idea{" +
                "author='" + author + '\'' +
                ", mail='" + mail + '\'' +
                ", description='" + description + '\'' +
                ", technos=" + technos +
                ", participants=" + participants +
                '}';
    }
}
