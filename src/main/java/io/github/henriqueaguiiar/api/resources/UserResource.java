package io.github.henriqueaguiiar.api.resources;


import io.github.henriqueaguiiar.api.domain.dto.UserDTO;
import io.github.henriqueaguiiar.api.domain.services.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResource {


    private UserServiceImpl userService;
    private ModelMapper modelMapper;

    @Autowired
    public UserResource(UserServiceImpl userService, ModelMapper  modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(modelMapper.map(userService.findById(id), UserDTO.class));
    }

}
