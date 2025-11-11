package io.github.henriqueaguiiar.api.domain.services;

import io.github.henriqueaguiiar.api.domain.dto.UserDTO;
import io.github.henriqueaguiiar.api.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    User findById(Integer id);

    List<User> findAll();

    User create(UserDTO userDTO);

    User update(UserDTO userDTO);

    void delete(Integer id);
}
