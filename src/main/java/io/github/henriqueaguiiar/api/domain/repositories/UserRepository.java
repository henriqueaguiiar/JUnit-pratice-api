package io.github.henriqueaguiiar.api.domain.repositories;

import io.github.henriqueaguiiar.api.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {



}
