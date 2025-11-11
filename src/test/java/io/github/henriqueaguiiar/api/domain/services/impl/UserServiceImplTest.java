package io.github.henriqueaguiiar.api.domain.services.impl;

import io.github.henriqueaguiiar.api.domain.dto.UserDTO;
import io.github.henriqueaguiiar.api.domain.entity.User;
import io.github.henriqueaguiiar.api.domain.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    public static final Integer ID = 1;
    public static final String NAME = "Henrique";
    public static final String EMAIL = "Henrique@gmail.com";
    public static final String PASSWORD = "123456";

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private User user;

    @Mock
    private UserDTO userDTO;

    @Mock
    private Optional<User> optionalUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.startUser();
    }

    @Test
    @DisplayName("When Find by Id then return User Instance")
    void whenFindByIdThenReturnUserInstance() {
        when(userRepository.findById(anyInt())).thenReturn(optionalUser);
        User response = userService.findById(ID);
        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }



    private void startUser(){
        user = User.builder()
                .id(ID)
                .name(NAME)
                .email(EMAIL)
                .password(PASSWORD)
                .build();

        userDTO = UserDTO.builder()
                .id(ID)
                .name(NAME)
                .email(EMAIL)
                .password(PASSWORD)
                .build();
        optionalUser = Optional.of(User.builder().id(ID).name(NAME).email(EMAIL).password(PASSWORD).build());
    }

}

