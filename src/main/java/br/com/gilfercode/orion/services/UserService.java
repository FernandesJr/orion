package br.com.gilfercode.orion.services;

import br.com.gilfercode.orion.dto.UserDTO;
import br.com.gilfercode.orion.dto.UserInsertDTO;
import br.com.gilfercode.orion.dto.UserUpdateDTO;
import br.com.gilfercode.orion.entities.User;
import br.com.gilfercode.orion.repositories.ClinicRepository;
import br.com.gilfercode.orion.repositories.UserRepository;
import br.com.gilfercode.orion.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

    private static final Object PASSWORD_NOT_CHANGED = null;

    @Autowired
    private UserRepository repository;

    @Autowired
    private ClinicRepository clinicRepository;

    @Transactional(readOnly = true)
    public Page<UserDTO> findAllUser(Pageable pageable){
        Page<User> users = repository.findAll(pageable);
        return users.map(user -> new UserDTO(user));
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id){
        User user = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Entity not found, check again"));
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO insert(UserInsertDTO dto){
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setActive(true);
        user.getClinics().add(clinicRepository.getReferenceById(dto.getClinicId()));
        User userDB = repository.save(user);
        return new UserDTO(userDB);
    }

    @Transactional
    public UserDTO update(UserUpdateDTO dto, Long userId){
        User user = repository.findById(userId).get();
        user.setEmail(dto.getEmail());
        user.setActive(dto.isActive());
        if(dto.getPassword() != PASSWORD_NOT_CHANGED)
            user.setPassword(dto.getPassword());
        repository.save(user);
        return new UserDTO(user);
    }
}
