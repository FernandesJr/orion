package br.com.gilfercode.orion.services.validation;

import br.com.gilfercode.orion.dto.UserUpdateDTO;
import br.com.gilfercode.orion.entities.User;
import br.com.gilfercode.orion.repositories.UserRepository;
import br.com.gilfercode.orion.resources.exceptions.FieldMessage;
import br.com.gilfercode.orion.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserUpdateValidator implements ConstraintValidator<UserUpdateValid, UserUpdateDTO> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void initialize(UserUpdateValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserUpdateDTO dto, ConstraintValidatorContext context) {

        var uriVars = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        long idUser = Long.parseLong(uriVars.get("id"));

        List<FieldMessage> error = new ArrayList<>();

        System.out.println(dto.toString());

        User user = userRepository.findById(idUser).orElseThrow(
                () -> new ResourceNotFoundException("Entity not found"));

        User userByEmail = userRepository.findByEmail(dto.getEmail());

        // Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista

        if (dto.getEmail() != user.getEmail() && userByEmail != null && userByEmail.getId() != idUser){
            error.add(new FieldMessage("email", "Email já cadastrado"));
        }

        if (!dto.getPassword().equals(dto.getConfirmPassword())){
            error.add(new FieldMessage("confirmPassword", "Senha e confirmação de senha não conferem"));
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
