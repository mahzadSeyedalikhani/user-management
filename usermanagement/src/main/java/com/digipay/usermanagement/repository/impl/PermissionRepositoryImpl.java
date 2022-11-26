package com.digipay.usermanagement.repository.impl;

import com.digipay.usermanagement.model.entity.Permission;
import com.digipay.usermanagement.repository.PermissionRepository;
import com.digipay.usermanagement.service.PermissionService;
import com.digipay.usermanagement.util.Util;
import jakarta.persistence.EntityManager;
import java.util.List;

public class PermissionRepositoryImpl implements PermissionRepository {
    private PermissionService permissionService;

    @Override
    public void saveRolePermission(Permission permission) {
        EntityManager entityManager = Util.getEntityMangerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(permission);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateRolePermission(Long id, String name) {
        EntityManager entityManager = Util.getEntityMangerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.find(Permission.class, id).setTitle(name);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void removeRolePermission(Long id) {
        EntityManager entityManager = Util.getEntityMangerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Permission permission = entityManager.find(Permission.class, id);
        entityManager.remove(permission);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Permission> readRolePermissions() {
        EntityManager entityManager = Util.getEntityMangerFactory().createEntityManager();
        return entityManager.createQuery("select t from Permission t ", Permission.class).getResultList();

    }

    @Override
    public Permission findPermissionById(Long id) {
        EntityManager entityManager = Util.getEntityMangerFactory().createEntityManager();
        Permission permission = entityManager.find(Permission.class, id);
        return permission;
    }
}
