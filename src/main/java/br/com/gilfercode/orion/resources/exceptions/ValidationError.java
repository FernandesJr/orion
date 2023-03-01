package br.com.gilfercode.orion.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StanderError{

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError() {}

    public List<FieldMessage> getErros() {
        return erros;
    }

    public void addError(String field, String message){
        erros.add(new FieldMessage(field, message));
    }
}
