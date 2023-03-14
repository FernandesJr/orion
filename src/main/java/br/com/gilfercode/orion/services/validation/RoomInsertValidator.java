package br.com.gilfercode.orion.services.validation;

import br.com.gilfercode.orion.dto.room.RoomDTO;
import br.com.gilfercode.orion.entities.Clinic;
import br.com.gilfercode.orion.entities.Room;
import br.com.gilfercode.orion.repositories.RoomRepository;
import br.com.gilfercode.orion.resources.exceptions.FieldMessage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RoomInsertValidator implements ConstraintValidator<RoomInsertValid, RoomDTO> {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void initialize(RoomInsertValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(RoomDTO dto, ConstraintValidatorContext context) {

        List<FieldMessage> error = new ArrayList<>();

        List<Room> rooms = roomRepository.findByClinic(new Clinic(dto.getClinicId()));

        for (Room room: rooms) {
            if(dto.getName().equals(room.getName()))
                error.add(new FieldMessage("name", "nome já existente em outra sala da clínica."));
            if(dto.getNumber().equals(room.getNumber()))
                error.add(new FieldMessage("number", "número já existente em outra sala da clínica."));
        }

        for (FieldMessage e : error) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getField())
                    .addConstraintViolation();
        }

        return error.isEmpty();
    }
}
