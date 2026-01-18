package com.sds.spring_boot_tutorial.mapper;

import com.sds.spring_boot_tutorial.dto.request.PermissionRequest;
import com.sds.spring_boot_tutorial.dto.response.PermissionResponse;
import com.sds.spring_boot_tutorial.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
