package io.github.henriqueaguiiar.api.domain.services.impl;

import io.github.henriqueaguiiar.api.domain.dto.UserDTO;
import io.github.henriqueaguiiar.api.domain.entity.User;
import io.github.henriqueaguiiar.api.domain.repositories.UserRepository;
import io.github.henriqueaguiiar.api.domain.services.UserService;
import io.github.henriqueaguiiar.api.domain.services.exceptions.DataIntegratyViolationException;
import io.github.henriqueaguiiar.api.domain.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,ModelMapper  modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public User findById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserDTO userDTO) {
        findByEmail(userDTO);
        return userRepository.save(modelMapper.map(userDTO, User.class););
    }

    private void findByEmail(UserDTO userDTO) {
        Optional<User> user = userRepository.findByEmail(userDTO.getEmail());
        if(user.isPresent()){
            throw new DataIntegratyViolationException("Email already exists");
        }
    }

}
