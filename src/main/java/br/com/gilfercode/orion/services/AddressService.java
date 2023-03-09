package br.com.gilfercode.orion.services;

import br.com.gilfercode.orion.dto.address.AddressDTO;
import br.com.gilfercode.orion.entities.Address;
import br.com.gilfercode.orion.repositories.AddressRepository;
import br.com.gilfercode.orion.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    @Transactional(readOnly = true)
    public AddressDTO findById(Long id){
        Address entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new AddressDTO(entity);
    }

}
