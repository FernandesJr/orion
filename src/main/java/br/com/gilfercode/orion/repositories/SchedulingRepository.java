package br.com.gilfercode.orion.repositories;

import br.com.gilfercode.orion.entities.Room;
import br.com.gilfercode.orion.entities.Scheduling;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {
    Page<Scheduling> findByRoom(Room room, Pageable pageable);
    List<Scheduling> findByCompletedAndRoom(boolean completed, Room room);
}
