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
}
