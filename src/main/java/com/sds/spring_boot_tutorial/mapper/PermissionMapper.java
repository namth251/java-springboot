package com.sds.spring_boot_tutorial.mapper;

import com.sds.spring_boot_tutorial.dto.request.PermissionRequest;
import com.sds.spring_boot_tutorial.dto.request.UserUpdateRequest;
import com.sds.spring_boot_tutorial.dto.response.PermissionResponse;
import com.sds.spring_boot_tutorial.entity.Permission;
import com.sds.spring_boot_tutorial.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
    void  updatePermission(@MappingTarget Permission permission, PermissionRequest request);

}
