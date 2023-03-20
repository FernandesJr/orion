package br.com.gilfercode.orion.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StanderError{

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError() {}

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String field, String message){
        errors.add(new FieldMessage(field, message));
    }
}
