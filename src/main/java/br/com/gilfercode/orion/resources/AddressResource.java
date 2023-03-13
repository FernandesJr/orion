package br.com.gilfercode.orion.resources;

import br.com.gilfercode.orion.dto.address.AddressDTO;
import br.com.gilfercode.orion.services.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
public class AddressResource {

    @Autowired
    private AddressService service;

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> findById(@PathVariable Long id){
        AddressDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> update(@PathVariable Long id, @RequestBody @Valid AddressDTO dto){
        AddressDTO addressDTO = service.update(id, dto);
        return ResponseEntity.ok(addressDTO);
    }
}
