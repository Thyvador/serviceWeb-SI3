package fr.polytech.si3.net.protocol;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Objet qui est envoyé par le client dans le cadre de la sérialisation Objet.
 * Cet objet possède deux attributs :
 * <ul>
 * <li>un attribut de type Type, qui correspond à la requête que l'on envoie</li>
 * <li>un attribut de type List&lt;Anytype&gt; qui correspond aux paramètres de la requête</li>
 * </ul>
 */
public class RequestContent<AnyType extends Serializable> implements Serializable {

    public Type type;
    public AnyType[] args;

    public RequestContent(Type type, AnyType... args) {
        this.type = type;
        this.args = args;
    }
}
