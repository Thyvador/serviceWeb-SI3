package fr.polytech.si3.net.protocol;

import java.io.Serializable;

/**
 * Created by alexh on 02/05/2017.
 */
public class Response<AnyType extends Serializable> {
    private boolean status;
    private AnyType[] data;

    public Response(boolean status, AnyType[] data) {
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

    public AnyType[] getData() {
        return data;
    }

    public void setData(AnyType[] data) {
        this.data = data;
    }
}
