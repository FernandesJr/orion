package br.com.gilfercode.orion.services.validation;

import br.com.gilfercode.orion.dto.clinic.ClinicInsertDTO;
import br.com.gilfercode.orion.entities.Clinic;
import br.com.gilfercode.orion.repositories.ClinicRepository;
import br.com.gilfercode.orion.resources.exceptions.FieldMessage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ClinicInsertValidator implements ConstraintValidator<ClinicInsertValid, ClinicInsertDTO> {

    @Autowired
    private ClinicRepository clinicRepository;

    @Override
    public void initialize(ClinicInsertValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ClinicInsertDTO clinicInsertDTO, ConstraintValidatorContext context) {

        List<FieldMessage> error = new ArrayList<>();
        Clinic clinic = clinicRepository.findByCnpj(clinicInsertDTO.getCnpj());

        // Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
        if(clinic != null){
            error.add(new FieldMessage("cnpj", "Cnpj já cadastrado por outra clínica."));
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
