package com.digipay.usermanagement.repository;

import com.digipay.usermanagement.model.entity.Role;


import java.util.List;

public interface RoleRepository {

    void saveUserRole(Role role);
    void updateUserRole(Long id, String name);
    public void removeUserRole(Long id);
    public List<Role> readUserRole();
    Role findRoleById(Long id);
}
