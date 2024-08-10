package com.sds.spring_boot_tutorial.repository;

import com.sds.spring_boot_tutorial.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoty extends JpaRepository<User, String> {
    boolean existsByUsername(String username);
}
