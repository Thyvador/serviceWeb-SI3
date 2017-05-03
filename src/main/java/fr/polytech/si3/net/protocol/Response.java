package fr.polytech.si3.net.protocol;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alexh on 02/05/2017.
 */
public class Response<AnyType extends Serializable> implements Serializable {
    private boolean status;
    private List<AnyType> data;

    public Response(boolean status, List<AnyType> data) {
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

    public List<AnyType> getData() {
        return data;
    }

    public void setData(List<AnyType> data) {
        this.data = data;
    }
}
