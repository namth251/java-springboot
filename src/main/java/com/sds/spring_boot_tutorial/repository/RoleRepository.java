package com.sds.spring_boot_tutorial.repository;

import com.sds.spring_boot_tutorial.entity.Permission;
import com.sds.spring_boot_tutorial.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {
}
