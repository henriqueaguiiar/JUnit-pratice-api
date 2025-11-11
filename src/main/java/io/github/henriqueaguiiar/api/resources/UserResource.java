package io.github.henriqueaguiiar.api.resources;


import io.github.henriqueaguiiar.api.domain.dto.UserDTO;
import io.github.henriqueaguiiar.api.domain.entity.User;
import io.github.henriqueaguiiar.api.domain.services.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserResource {


    public static final String ID = "/{id}";
    private UserServiceImpl userService;
    private ModelMapper modelMapper;

    @Autowired
    public UserResource(UserServiceImpl userService, ModelMapper  modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(ID)
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(modelMapper.map(userService.findById(id), UserDTO.class));
    }


    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok().body(userService.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create (@RequestBody UserDTO userDTO) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path(ID)
                .buildAndExpand(userService.create(userDTO).getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(ID)
    public ResponseEntity<UserDTO> update (@RequestBody @PathVariable Integer id, UserDTO userDTO) {
        userDTO.setId(id);
        return ResponseEntity.ok().body(modelMapper.map(userService.update(userDTO), UserDTO.class));
    }

    @DeleteMapping(ID)
    public ResponseEntity<List<UserDTO>> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
