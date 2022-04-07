package com.fabio.cursomc.resources.errors;

import com.fabio.cursomc.exceptions.ObjectCannotBeDeleteException;
import com.fabio.cursomc.exceptions.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<MsgError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){

        MsgError msgError = new MsgError(HttpStatus.NOT_FOUND.value(),e.getMessage(), Instant.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msgError);
    }

    @ExceptionHandler(ObjectCannotBeDeleteException.class)
    public ResponseEntity<MsgError> objectCannotBeDelete(ObjectCannotBeDeleteException e, HttpServletRequest request){

        MsgError msgError = new MsgError(HttpStatus.BAD_REQUEST.value(),e.getMessage(), Instant.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msgError);
    }


}
