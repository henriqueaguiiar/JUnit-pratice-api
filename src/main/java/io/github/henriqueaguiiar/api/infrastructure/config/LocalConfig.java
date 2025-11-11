package io.github.henriqueaguiiar.api.infrastructure.config;


import io.github.henriqueaguiiar.api.domain.entity.User;
import io.github.henriqueaguiiar.api.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    private UserRepository userRepository;

    @Autowired
    public LocalConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public CommandLineRunner startDb(){
        return args -> {
            User u1 = new User(null, "Henrique", "henrique@gmail.com", "123456");
            User u2 = new User(null, "Daniel", "daniel@gmail.com", "123456");
            userRepository.saveAll(List.of(u1,u2));
        };
    }




}
