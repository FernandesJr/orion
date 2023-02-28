package br.com.gilfercode.orion.repositories;

import br.com.gilfercode.orion.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
