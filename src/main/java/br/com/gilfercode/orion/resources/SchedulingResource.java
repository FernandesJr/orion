package br.com.gilfercode.orion.resources;

import br.com.gilfercode.orion.dto.scheduling.SchedulingDTO;
import br.com.gilfercode.orion.services.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scheduling")
public class SchedulingResource {

    @Autowired
    private SchedulingService service;

    @GetMapping("/{id}")
    public ResponseEntity<SchedulingDTO> findById(@PathVariable Long id){
        SchedulingDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/all/room/{roomId}")
    public ResponseEntity<Page<SchedulingDTO>> findByRoom(@PathVariable Long roomId, Pageable pageable){
        Page<SchedulingDTO> page = service.findAllByRoom(pageable, roomId);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<List<SchedulingDTO>> findCompletedByRoom(@PathVariable Long roomId){
        List<SchedulingDTO> schedulingDTOS = service.findCompletedByRoom(roomId);
        return ResponseEntity.ok(schedulingDTOS);
    }
}
