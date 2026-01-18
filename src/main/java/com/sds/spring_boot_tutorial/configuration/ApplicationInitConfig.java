package com.sds.spring_boot_tutorial.configuration;

import com.sds.spring_boot_tutorial.entity.User;
import com.sds.spring_boot_tutorial.enums.Role;
import com.sds.spring_boot_tutorial.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository) {
        return arg -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                var roles = new HashSet<String>();
                roles.add(Role.ADMIN.name());
                User user = User.builder().username("admin")
//                        .roles(roles)
                        .password(passwordEncoder.encode("admin")).build();
                userRepository.save(user);
                log.warn("admin created with default password admin!!!!");
            }
        };
    }
}
