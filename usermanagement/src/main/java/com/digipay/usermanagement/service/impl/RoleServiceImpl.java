package com.digipay.usermanagement.service.impl;

import com.digipay.usermanagement.model.entity.Permission;
import com.digipay.usermanagement.model.entity.Role;
import com.digipay.usermanagement.repository.PermissionRepository;
import com.digipay.usermanagement.repository.RoleRepository;
import com.digipay.usermanagement.service.RoleService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    public RoleServiceImpl(RoleRepository roleRepository, PermissionRepository permissionRepository) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }

    @Override
    public void createUserRole(String roleTitle, String[] roleId) {
        Role role = new Role();
        role.setTitle(roleTitle);
        Set<Permission> permissionSet = new HashSet<>();
        for(int index = 0 ; index<roleId.length; index++){
            long id = Long.parseLong(roleId[index]);
            Permission permission = permissionRepository.findPermissionById(id);
            permissionSet.add(permission);
        }
        role.setPermissions(permissionSet);
        roleRepository.saveUserRole(role);
        System.out.println("your role with required permission is created successfully :)");
    }

    @Override
    public List displayUserRole() {
        return roleRepository.readUserRole();
    }

    @Override
    public void updateUserRole(Long id, String name) {
        roleRepository.updateUserRole(id, name);
    }

    @Override
    public void removeUserRole(Long id) {
        roleRepository.removeUserRole(id);
    }


}
