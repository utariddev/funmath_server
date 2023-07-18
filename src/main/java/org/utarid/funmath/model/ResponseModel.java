package org.utarid.funmath.model;

import java.util.ArrayList;
import java.util.List;

public class ResponseModel<T> {
    private String error;
    private List<String> message;
    private T data;

    public ResponseModel(String error, List<String> message) {
        this.error = error;
        this.message = message;
    }

    public ResponseModel() {
        this.error = "0";
        this.message = new ArrayList<>(List.of("success"));
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
