package io.github.henriqueaguiiar.api.domain.services;

import io.github.henriqueaguiiar.api.domain.entity.User;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    User findById(Integer id);

}
