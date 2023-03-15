package br.com.gilfercode.orion.services.validation;

import br.com.gilfercode.orion.dto.room.RoomDTO;
import br.com.gilfercode.orion.entities.Clinic;
import br.com.gilfercode.orion.entities.Room;
import br.com.gilfercode.orion.repositories.ClinicRepository;
import br.com.gilfercode.orion.repositories.RoomRepository;
import br.com.gilfercode.orion.repositories.UserRepository;
import br.com.gilfercode.orion.resources.exceptions.FieldMessage;
import br.com.gilfercode.orion.services.exceptions.BadRequestException;
import br.com.gilfercode.orion.services.exceptions.ResourceNotFoundException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RoomValidator implements ConstraintValidator<RoomValid, RoomDTO> {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    @Override
    public void initialize(RoomValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(RoomDTO dto, ConstraintValidatorContext context) {

        //Após implementação da autenticação, também verificar se o user pertence à clìnica

        if(dto.getClinicId() == null) throw new BadRequestException("clinicId can't be null");

        Clinic clinic = clinicRepository.findById(dto.getClinicId())
                .orElseThrow(() -> new ResourceNotFoundException("Clinic not found"));

        List<FieldMessage> error = new ArrayList<>();

        List<Room> rooms = roomRepository.findByClinic(clinic);

        for (Room room: rooms) {
            if(dto.getName().equals(room.getName()) && !room.getId().equals(dto.getId()))
                error.add(new FieldMessage("name", "nome já existente em outra sala da clínica."));
            if(dto.getNumber().equals(room.getNumber()) && !room.getId().equals(dto.getId()))
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
