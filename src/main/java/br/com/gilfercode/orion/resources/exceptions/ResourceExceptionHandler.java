package br.com.gilfercode.orion.resources.exceptions;

import br.com.gilfercode.orion.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice //Listen exception to the app
public class ResourceExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StanderError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StanderError standerError = new StanderError();
        standerError.setStatus(status.value());
        standerError.setTimestamp(Instant.now());
        standerError.setError("Resource not found");
        standerError.setMessage(e.getMessage());
        standerError.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(standerError);
    }
}
