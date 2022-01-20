package br.com.dicasdeumdev.demo.repositories;

import br.com.dicasdeumdev.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
