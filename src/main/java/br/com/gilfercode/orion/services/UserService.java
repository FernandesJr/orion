package br.com.gilfercode.orion.services;

import br.com.gilfercode.orion.dto.user.UserDTO;
import br.com.gilfercode.orion.dto.user.UserInsertDTO;
import br.com.gilfercode.orion.dto.user.UserUpdateDTO;
import br.com.gilfercode.orion.entities.Clinic;
import br.com.gilfercode.orion.entities.Role;
import br.com.gilfercode.orion.entities.User;
import br.com.gilfercode.orion.enums.TypesRole;
import br.com.gilfercode.orion.repositories.ClinicRepository;
import br.com.gilfercode.orion.repositories.RoleRepository;
import br.com.gilfercode.orion.repositories.UserRepository;
import br.com.gilfercode.orion.services.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
public class UserService implements UserDetailsService {

    private static final Object PASSWORD_NOT_CHANGED = null;

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private RoleRepository roleRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setActive(true);
        user.getClinics().add(clinicRepository.getReferenceById(dto.getClinicId()));
        dto.getRoles().forEach(role -> user.addRole(roleRepository.getReferenceById(role.getId())));
        User userDB = repository.save(user);
        return new UserDTO(userDB);
    }

    @Transactional
    public UserDTO update(UserUpdateDTO dto, Long userId){
        User user = repository.findById(userId).get();
        user.setEmail(dto.getEmail());
        user.setActive(dto.isActive());
        if(dto.getPassword() != PASSWORD_NOT_CHANGED)
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        repository.save(user);
        return new UserDTO(user);
    }

    public void userDefaultClinic(Long clinicId){
        Clinic clinic = clinicRepository.getReferenceById(clinicId);
        User user = new User();
        user.getClinics().add(clinic);
        user.setEmail(clinic.getCnpj() + "@orin.com.br");
        user.setPassword(prepareKey());
        user.setActive(true);
        user.addRole(new Role(TypesRole.ADMIN));
        repository.save(user);
    }

    public String prepareKey(){
        UUID uuid = UUID.randomUUID();
        String key = uuid.toString().replace("-", "");
        return key;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username);
        if (user == null) {
            logger.error("NOT FOUND USER: " + username);
            throw new UsernameNotFoundException("User not found, check your credentials");
        }
        logger.info("USER FOUND: " + username);
        return user;
    }
}
