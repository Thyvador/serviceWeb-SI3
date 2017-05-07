package fr.polytech.si3.net.protocol;

import java.io.Serializable;
import java.util.List;

/**
 * Response is the object sent by the server to the client after handling the request.
 */
public class Response<AnyType extends Serializable> implements Serializable {
    private boolean status;
    private List<AnyType> data;

    /**
     * Default constructor of Response.
     *
     * @param status the status of the response : true if success, else otherwise.
     * @param data   the data sent back to the client.
     */
    public Response(boolean status, List<AnyType> data) {
        this.status = status;
        this.data = data;
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

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
