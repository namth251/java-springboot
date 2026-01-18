package com.sds.spring_boot_tutorial.controller;

import com.sds.spring_boot_tutorial.dto.request.ApiResponse;
import com.sds.spring_boot_tutorial.dto.request.PermissionRequest;
import com.sds.spring_boot_tutorial.dto.request.RoleRequest;
import com.sds.spring_boot_tutorial.dto.response.PermissionResponse;
import com.sds.spring_boot_tutorial.dto.response.RoleResponse;
import com.sds.spring_boot_tutorial.service.PermissionService;
import com.sds.spring_boot_tutorial.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleController {
    RoleService roleService;
    @PostMapping
    ApiResponse<RoleResponse> create(@RequestBody RoleRequest request) {
        return ApiResponse.<RoleResponse>builder()
                .result(roleService.create(request)).build();
    }

    @GetMapping
    ApiResponse<List<RoleResponse>> getAll() {
        return ApiResponse.<List<RoleResponse>>builder()
                .result(roleService.getAll())
                .build();
    }

    @DeleteMapping("/{roleId}")
    ApiResponse<Void> delete(@PathVariable("roleId") String role) {
        roleService.delete(role);
        return ApiResponse.<Void>builder()
                .build();
    }
}
