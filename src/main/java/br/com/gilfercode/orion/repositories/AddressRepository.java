package br.com.gilfercode.orion.repositories;

import br.com.gilfercode.orion.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
