package com.digipay.usermanagement.service;

import java.util.List;

public interface PermissionService {
    void createPermission(String title);
    List displayPermission();
    void updatePermission(Long id, String name);
    void removePermission(Long id);

}
