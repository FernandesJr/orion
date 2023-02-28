package br.com.gilfercode.orion.repositories;

import br.com.gilfercode.orion.entities.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
}
