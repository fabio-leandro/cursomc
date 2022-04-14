package com.fabio.cursomc.resources.errors;

import java.io.Serializable;
import java.time.Instant;

public class FieldErrors extends MsgError implements Serializable {

    private static final long serialVersionUID = 1L;

    private String field;
    private String message;

    public FieldErrors(){}

    public FieldErrors(Integer status, String msg, Instant timeStamp, String field, String message) {
        super(status, msg, timeStamp);
        this.field = field;
        this.message = message;
    }

    public FieldErrors(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
