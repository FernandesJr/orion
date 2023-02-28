package br.com.gilfercode.orion.repositories;

import br.com.gilfercode.orion.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
