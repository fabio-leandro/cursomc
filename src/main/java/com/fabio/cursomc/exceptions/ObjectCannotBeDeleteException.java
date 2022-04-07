package com.fabio.cursomc.exceptions;

public class ObjectCannotBeDeleteException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ObjectCannotBeDeleteException (String msg){
        super(msg);
    }

    public ObjectCannotBeDeleteException(String msg, Throwable cause){
        super(msg,cause);
    }
}
