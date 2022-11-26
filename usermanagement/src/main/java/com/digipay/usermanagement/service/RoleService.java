package com.digipay.usermanagement.service;

import java.util.List;

public interface RoleService {
   void createUserRole(String roleTitle, String[] roleId);
   List displayUserRole();
   void updateUserRole(Long id, String name);
   void removeUserRole(Long id);
}
