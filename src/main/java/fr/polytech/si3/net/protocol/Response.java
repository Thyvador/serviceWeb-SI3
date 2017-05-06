package fr.polytech.si3.net.protocol;

import java.io.Serializable;
import java.util.List;

/**
 * Objet représentant la réponse qui est renvoyée par le serveur après traitement de la requête du client.
 * Cet objet possède deux attributs :
 * <ul>
 * <li>un attribut de type boolean, qui correspond au statut de la requête :
 * <ul>
 * <li>true : la requête a réussi</li>
 * <li>false : la requête a échoué</li>
 * </ul>
 * </li>
 * <li>un attribut de type List&lt;Anytype&gt; qui correspond aux paramètres de la réponse</li>
 * </ul>
 */
public class Response <AnyType extends Serializable> implements Serializable {
    private boolean status;
    private List <AnyType> data;

    public Response(boolean status, List <AnyType> data) {
        this.status = status;
        this.data = data;
    }

    public Response(boolean b) {
        status = b;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List <AnyType> getData() {
        return data;
    }

    public void setData(List <AnyType> data) {
        this.data = data;
    }
}
