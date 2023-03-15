package br.com.gilfercode.orion.resources;

import br.com.gilfercode.orion.dto.room.RoomDTO;
import br.com.gilfercode.orion.services.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<RoomDTO> create(@RequestBody @Valid RoomDTO dto){
        RoomDTO roomDTO = service.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().
                path("/{id}").buildAndExpand(roomDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(roomDTO);
    }

    @PutMapping
    public ResponseEntity<RoomDTO> update(@RequestBody @Valid RoomDTO dto){
        RoomDTO roomDTO = service.update(dto);
        return ResponseEntity.ok(roomDTO);
    }
}
