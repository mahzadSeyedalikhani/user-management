package com.digipay.usermanagement.service.impl;


import com.digipay.usermanagement.model.entity.Role;
import com.digipay.usermanagement.model.entity.User;
import com.digipay.usermanagement.repository.RoleRepository;
import com.digipay.usermanagement.repository.UserRepository;
import com.digipay.usermanagement.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    Scanner scanner = new Scanner(System.in);
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public void createUser(String username, int nationalCode, String[] roleId) {
        User user = new User();
        user.setUsername(username);
        user.setNationalCode(nationalCode);
        for (int index = 0; index< roleId.length; index++){
            long id = Long.parseLong(roleId[index]);
            Role role = roleRepository.findRoleById(id);
            user.setRole(role);
        }
        userRepository.saveUser(user);
        System.out.println("your user with required role is created successfully :)");
    }

    public List displayUser() {
        return userRepository.readUser();
    }

    public void updateUser(Long id, String name) {
        userRepository.updateUser(id, name);
    }

    public void removeUser(Long id) {
        userRepository.removeUser(id);
    }

}