package br.com.gilfercode.orion.resources;

import br.com.gilfercode.orion.dto.room.RoomDTO;
import br.com.gilfercode.orion.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomResource {

    @Autowired
    private RoomService service;

    @GetMapping("/clinic/{clinicId}")
    public ResponseEntity<List<RoomDTO>> findAllByClinic(@PathVariable Long clinicId){
        List<RoomDTO> rooms = service.findAllByClinic(clinicId);
        return ResponseEntity.ok(rooms);
    }
}
