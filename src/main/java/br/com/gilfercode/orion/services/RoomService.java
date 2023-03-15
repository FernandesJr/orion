package br.com.gilfercode.orion.services;

import br.com.gilfercode.orion.dto.room.RoomDTO;
import br.com.gilfercode.orion.entities.Clinic;
import br.com.gilfercode.orion.entities.Room;
import br.com.gilfercode.orion.repositories.ClinicRepository;
import br.com.gilfercode.orion.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository repository;

    @Transactional(readOnly = true)
    public List<RoomDTO> findAllByClinic(Long clinicId){
        List<Room> rooms = repository.findByClinic(new Clinic(clinicId));
        List<RoomDTO> dto = new ArrayList<>();
        rooms.forEach(r -> dto.add(new RoomDTO(r)));
        return dto;
    }

    @Transactional
    public RoomDTO create(RoomDTO dto){
        Room room = new Room();
        room.setClinic(new Clinic(dto.getClinicId()));
        room.setName(dto.getName());
        room.setNumber(dto.getNumber());
        room.setStartAppointments(dto.getStartAppointments());
        room.setFinishAppointments(dto.getFinishAppointments());
        Room entity = repository.save(room);
        return new RoomDTO(entity);
    }

    @Transactional
    public RoomDTO update(RoomDTO dto){
        Room room = repository.getReferenceById(dto.getId());
        room.setName(dto.getName());
        room.setNumber(dto.getNumber());
        room.setStartAppointments(dto.getStartAppointments());
        room.setFinishAppointments(dto.getFinishAppointments());
        Room entity = repository.save(room);
        return new RoomDTO(entity);
    }
}
