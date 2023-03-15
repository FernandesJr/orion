package br.com.gilfercode.orion.repositories;

import br.com.gilfercode.orion.entities.Clinic;
import br.com.gilfercode.orion.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByClinic(Clinic clinic);
    List<Room> findByClinicAndActive(Clinic clinic, boolean active);
}
