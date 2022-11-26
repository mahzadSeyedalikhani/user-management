package com.digipay.usermanagement.service.impl;

import com.digipay.usermanagement.model.entity.Permission;
import com.digipay.usermanagement.repository.PermissionRepository;
import com.digipay.usermanagement.service.PermissionService;
import java.util.List;


public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;

    public PermissionServiceImpl(PermissionRepository permissionRepository){
        this.permissionRepository = permissionRepository;
    }

    @Override
    public void createPermission(String title) {
        Permission permission = new Permission();
        permission.setTitle(title);
        permissionRepository.saveRolePermission(permission);
        System.out.println("your role with required permission is created successfully :)");
    }

    @Override
    public List displayPermission() {
        return permissionRepository.readRolePermissions();
    }

    @Override
    public void updatePermission(Long id, String name) {
        permissionRepository.updateRolePermission(id, name);
    }

    @Override
    public void removePermission(Long id) {
        permissionRepository.removeRolePermission(id);
    }

}
