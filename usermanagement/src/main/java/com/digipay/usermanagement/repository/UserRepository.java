package com.digipay.usermanagement.repository;

import com.digipay.usermanagement.model.entity.User;
import java.util.List;

public interface UserRepository {
     void saveUser(User user);
     void updateUser(Long id, String name);
     void removeUser(Long id);
    List<User> readUser();
}
