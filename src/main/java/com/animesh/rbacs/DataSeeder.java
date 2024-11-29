package com.animesh.rbacs;

import com.animesh.rbacs.entity.Role;
import com.animesh.rbacs.entity.Users;
import com.animesh.rbacs.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This class is only for testing purposes as new user registration is not implemented yet
 */

@Component
public class DataSeeder {
    private final UserRepository userRepository;

    public DataSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void seedUsers() {
        if (userRepository.count() == 0) {
            Users admin = new Users();
            admin.setUsername("admin");
            admin.setPassword(new BCryptPasswordEncoder().encode("admin123"));
            admin.setRole(Role.ADMIN);

            Users user = new Users();
            user.setUsername("user");
            user.setPassword(new BCryptPasswordEncoder().encode("user123"));
            user.setRole(Role.USER);

            userRepository.saveAll(List.of(admin, user));
        }
    }
}

