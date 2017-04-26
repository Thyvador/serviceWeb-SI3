package fr.polytech.si3.net;

import java.util.List;

/**
 * Created by alexh on 26/04/2017.
 */
public class Idea {
    private String author;
    private String mail;
    private String description;
    private List<String> technos;

    public Idea(String author, String mail, String description, List<String> technos) {
        this.author = author;
        this.mail = mail;
        this.description = description;
        this.technos = technos;
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

    public void setTechnos(List<String> technos) {
        this.technos = technos;
    }
}
