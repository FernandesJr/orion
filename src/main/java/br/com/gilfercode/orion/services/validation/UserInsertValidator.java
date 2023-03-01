package br.com.gilfercode.orion.services.validation;

import br.com.gilfercode.orion.dto.UserInsertDTO;
import br.com.gilfercode.orion.entities.User;
import br.com.gilfercode.orion.repositories.UserRepository;
import br.com.gilfercode.orion.resources.exceptions.FieldMessage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UserInsertValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserInsertDTO userInsertDTO, ConstraintValidatorContext context) {

        List<FieldMessage> error = new ArrayList<>();

        User user = userRepository.findByEmail(userInsertDTO.getEmail());

        // Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
        if (user != null){
            error.add(new FieldMessage("email", "email já cadastrado"));
        }

        for (FieldMessage e : error) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getField())
                    .addConstraintViolation();
        }

        //Caso tenha algum item na lista o ExceptionHandler captura
        return error.isEmpty();
    }
}
