package br.com.gilfercode.orion.resources;

import br.com.gilfercode.orion.dto.ClinicDTO;
import br.com.gilfercode.orion.services.ClinicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clinics")
public class ClinicResource {

    @Autowired
    private ClinicService service;

    @GetMapping
    public ResponseEntity<Page<ClinicDTO>> findAll(Pageable pageable){
        Page<ClinicDTO> page = service.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicDTO> findById(@PathVariable Long id){
        ClinicDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ClinicDTO> create(@RequestBody @Valid ClinicDTO dto){
        ClinicDTO clinicDTO = service.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("{id}").buildAndExpand(clinicDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(clinicDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClinicDTO> update(@RequestBody @Valid ClinicDTO dto, @PathVariable Long id){
        ClinicDTO clinicDTO = service.update(dto, id);
        return ResponseEntity.ok(clinicDTO);
    }

}
