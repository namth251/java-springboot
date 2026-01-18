package com.sds.spring_boot_tutorial.mapper;

import com.sds.spring_boot_tutorial.dto.request.PermissionRequest;
import com.sds.spring_boot_tutorial.dto.request.RoleRequest;
import com.sds.spring_boot_tutorial.dto.response.PermissionResponse;
import com.sds.spring_boot_tutorial.dto.response.RoleResponse;
import com.sds.spring_boot_tutorial.entity.Permission;
import com.sds.spring_boot_tutorial.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse roleResponse(Role role);
}
