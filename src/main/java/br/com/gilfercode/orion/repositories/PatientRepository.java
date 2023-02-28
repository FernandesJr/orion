package br.com.gilfercode.orion.repositories;

import br.com.gilfercode.orion.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
