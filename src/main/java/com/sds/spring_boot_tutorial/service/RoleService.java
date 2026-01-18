package com.sds.spring_boot_tutorial.service;

import com.sds.spring_boot_tutorial.dto.request.PermissionRequest;
import com.sds.spring_boot_tutorial.dto.request.RoleRequest;
import com.sds.spring_boot_tutorial.dto.response.PermissionResponse;
import com.sds.spring_boot_tutorial.dto.response.RoleResponse;
import com.sds.spring_boot_tutorial.entity.Permission;
import com.sds.spring_boot_tutorial.mapper.PermissionMapper;
import com.sds.spring_boot_tutorial.mapper.RoleMapper;
import com.sds.spring_boot_tutorial.repository.PermissionRepository;
import com.sds.spring_boot_tutorial.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    RoleMapper roleMapper;

    public RoleResponse create(RoleRequest request) {
        var role = roleMapper.toRole(request);
        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));
        role = roleRepository.save(role);
        return roleMapper.roleResponse(role);
    }

    public List<RoleResponse> getAll() {
        var roles = roleRepository.findAll();
        return roles.stream().map(roleMapper::roleResponse).toList();
    }

    public void delete(String role){
        roleRepository.deleteById(role);
    }
}
