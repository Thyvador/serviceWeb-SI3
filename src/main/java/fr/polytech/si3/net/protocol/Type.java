package fr.polytech.si3.net.protocol;

import java.io.Serializable;

/**
 * Enum recensant les six requêtes supportées par le serveur, avec le nombre de paramètres en paramètre :
 * <ul>
 *     <li>add : ajoute l'idée passée en paramètre</li>
 *     <li>list : affiche l'ensemble des idées présentes sur le serveur</li>
 *     <li>participate : ajoute le client en tant que participant à l'idée passée en paramètre</li>
 *     <li>listpart : liste les participants de l'idée passée en paramètre</li>
 *     <li>delete : supprime l'idée passée en paramètre</li>
 *     <li>edit : modifie l'idée passée en premier paramètre par une nouvelle idée passée en deuxième paramètre</li>
 * </ul>
 */
public enum Type implements Serializable{
    ADD(1),
    LIST(0),
    PARTCIPATE(1),
    LISTPART(1),
    DELETE(1),
    EDIT(2);

    public int argc;

    Type(int i) {
        argc = i;
    }
}
