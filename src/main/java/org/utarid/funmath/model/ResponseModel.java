package org.utarid.funmath.model;

public class ResponseModel {
    private String error;
    private String status;
    private String message;

    public ResponseModel(String error, String status, String message) {
        this.error = error;
        this.status = status;
        this.message = message;
    }

    public ResponseModel() {
        this.error = "0";
        this.status = "0";
        this.message = "success";
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
