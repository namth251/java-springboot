package com.sds.spring_boot_tutorial.repository;

import com.sds.spring_boot_tutorial.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,String> {
}
