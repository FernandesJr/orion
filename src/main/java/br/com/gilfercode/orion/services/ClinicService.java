package br.com.gilfercode.orion.services;

import br.com.gilfercode.orion.dto.clinic.ClinicDTO;
import br.com.gilfercode.orion.dto.clinic.ClinicInsertDTO;
import br.com.gilfercode.orion.entities.Address;
import br.com.gilfercode.orion.entities.Clinic;
import br.com.gilfercode.orion.repositories.ClinicRepository;
import br.com.gilfercode.orion.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClinicService {

    @Autowired
    private ClinicRepository repository;

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public Page<ClinicDTO> findAll(Pageable pageable){
        Page<Clinic> page = repository.findAll(pageable);
        return page.map((c) -> new ClinicDTO(c));
    }

    @Transactional(readOnly = true)
    public ClinicDTO findById(Long id){
        Clinic entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new ClinicDTO(entity);
    }

    @Transactional
    public ClinicDTO create(ClinicInsertDTO dto){
        Clinic entity = new Clinic();
        entity.setCnpj(dto.getCnpj());
        entity.setName(dto.getName());
        entity.setImageUrl(dto.getImageUrl());
        entity.setAddress(new Address(dto.getAddressDto()));
        Clinic clinic = repository.save(entity);
        userService.userDefaultClinic(clinic.getId()); //User de inicialização da clínica ADM
        return new ClinicDTO(clinic);
    }

    @Transactional
    public ClinicDTO update(ClinicDTO dto, Long id){
        Clinic entity = repository.getReferenceById(id);
        entity.setName(dto.getName());
        entity.setImageUrl(dto.getImageUrl());
        return new ClinicDTO(entity);
    }
}
