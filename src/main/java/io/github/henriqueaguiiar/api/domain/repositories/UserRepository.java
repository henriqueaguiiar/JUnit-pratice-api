package io.github.henriqueaguiiar.api.domain.repositories;

import io.github.henriqueaguiiar.api.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    Optional<User> findByEmail(String email);
}
