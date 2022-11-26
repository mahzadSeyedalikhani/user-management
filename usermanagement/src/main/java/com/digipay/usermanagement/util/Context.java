package com.digipay.usermanagement.util;

import com.digipay.usermanagement.repository.PermissionRepository;
import com.digipay.usermanagement.repository.RoleRepository;
import com.digipay.usermanagement.repository.UserRepository;
import com.digipay.usermanagement.repository.impl.PermissionRepositoryImpl;
import com.digipay.usermanagement.repository.impl.RoleRepositoryImpl;
import com.digipay.usermanagement.repository.impl.UserRepositoryImpl;
import com.digipay.usermanagement.service.PermissionService;
import com.digipay.usermanagement.service.RoleService;
import com.digipay.usermanagement.service.UserService;
import com.digipay.usermanagement.service.impl.PermissionServiceImpl;
import com.digipay.usermanagement.service.impl.RoleServiceImpl;
import com.digipay.usermanagement.service.impl.UserServiceImpl;


public class Context {
    private static final UserRepository userRepository;
    private static final RoleRepository roleRepository;
    private static final PermissionRepository permissionRepository;
    private static final UserService userService;
    private static final RoleService roleService;
    private static final PermissionService permissionService;

    static {
           userRepository = new UserRepositoryImpl();
           roleRepository = new RoleRepositoryImpl();
           permissionRepository = new PermissionRepositoryImpl();
           userService = new UserServiceImpl(userRepository, roleRepository);
           permissionService = new PermissionServiceImpl(permissionRepository);
           roleService = new RoleServiceImpl(roleRepository, permissionRepository);

           }

    public static UserRepository getUserRepository() {
        return userRepository;
    }

    public static UserService getUserService() {
        return userService;
    }

    public static RoleService getRoleService() {
        return roleService;
    }

    public static PermissionService getPermissionService() {
        return permissionService;
    }
}
