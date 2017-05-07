package fr.polytech.si3.net.protocol;

import java.io.Serializable;

/**
 * Enum recensant les deux requêtes que nous avons implémentées, avec le nombre de paramètres en paramètre :
 * <ul>
 *     <li>add : ajoute l'idée passée en paramètre</li>
 *     <li>list : affiche l'ensemble des idées présentes sur le serveur</li>
 * </ul>
 */
public enum Type implements Serializable{
    ADD(1),
    LIST(0),
    PARTCIPATE(1),
    LISTPART(0),
    DELETE(1),
    EDIT(2);

    public int argc;

    Type(int i) {
        argc = i;
    }
}
