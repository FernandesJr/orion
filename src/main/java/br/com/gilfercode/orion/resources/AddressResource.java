package br.com.gilfercode.orion.resources;

import br.com.gilfercode.orion.dto.address.AddressDTO;
import br.com.gilfercode.orion.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
