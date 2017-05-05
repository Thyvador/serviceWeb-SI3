package fr.polytech.si3.net;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alexh on 26/04/2017.
 */
public class Idea implements Serializable{
    private String author;
    private String mail;
    private String description;
    private List<String> technos;
    private List<String> participants;

    public Idea(String author, String mail, String description, List<String> technos, List<String> participants) {
        this.author = author;
        this.mail = mail;
        this.description = description;
        this.technos = technos;
        this.participants = participants;
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

    public List<String> getTechnos() {
        return technos;
    }

    public void setTechnos(String techno) {
        this.technos.add(techno);
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void addParticipants(String participant) {
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
