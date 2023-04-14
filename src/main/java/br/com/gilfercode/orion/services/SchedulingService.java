package br.com.gilfercode.orion.services;

import br.com.gilfercode.orion.dto.scheduling.SchedulingDTO;
import br.com.gilfercode.orion.entities.Room;
import br.com.gilfercode.orion.entities.Scheduling;
import br.com.gilfercode.orion.repositories.SchedulingRepository;
import br.com.gilfercode.orion.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class SchedulingService {

    private static final boolean NOT_COMPLETED = false;

    @Autowired
    private SchedulingRepository repository;

    @Transactional(readOnly = true)
    public SchedulingDTO findById(Long id){
        Scheduling entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Scheduling not exist"));
        return new SchedulingDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<SchedulingDTO> findAllByRoom(Pageable pageable, Long idRoom){
        Page<Scheduling> page = repository.findByRoom(new Room(idRoom), pageable);
        return page.map(e -> new SchedulingDTO(e));
    }

    @Transactional(readOnly = true)
    public List<SchedulingDTO> findCompletedByRoom(Long idRoom){
        List<Scheduling> list = repository.findByCompletedAndRoom(NOT_COMPLETED, new Room(idRoom));
        return list.stream().map(s -> new SchedulingDTO(s)).collect(Collectors.toList());
    }

}
