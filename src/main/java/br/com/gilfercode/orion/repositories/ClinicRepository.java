package br.com.gilfercode.orion.repositories;

import br.com.gilfercode.orion.entities.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
    Clinic findByCnpj(String cnpj);
}
