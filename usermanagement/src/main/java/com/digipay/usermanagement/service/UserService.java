package com.digipay.usermanagement.service;

import java.util.List;

public interface UserService {
    void createUser(String name, int nationalCode, String[] roleId);
    List displayUser();
    void updateUser(Long id, String name);
    void removeUser(Long id);

}
