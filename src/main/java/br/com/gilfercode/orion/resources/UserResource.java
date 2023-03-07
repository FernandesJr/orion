package br.com.gilfercode.orion.resources;

import br.com.gilfercode.orion.dto.user.UserDTO;
import br.com.gilfercode.orion.dto.user.UserInsertDTO;
import br.com.gilfercode.orion.dto.user.UserUpdateDTO;
import br.com.gilfercode.orion.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable){
        return ResponseEntity.ok(service.findAllUser(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserInsertDTO dto){
        UserDTO userDTO = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(userDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(userDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@Valid @RequestBody UserUpdateDTO dto, @PathVariable Long id){
        UserDTO userDTO = service.update(dto, id);
        return ResponseEntity.ok(userDTO);
    }
}
