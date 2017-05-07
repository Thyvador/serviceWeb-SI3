package fr.polytech.si3.net.protocol;

import java.io.Serializable;
import java.util.List;

/**
 * Objet représentant une idée.
 * Cet objet possède cinq attributs :
 * <ul>
 * <li>trois attributs de type Sring, qui correspondent à l'auteur, au mail et à la description</li>
 * <li>deux attributs de type List&lt;Anytype&gt; qui correspondent aux technologies et aux participants</li>
 * </ul>
 */
public class Idea implements Serializable {
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

    public void setTechnos(String techno) {
        this.technos.add(techno);
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
