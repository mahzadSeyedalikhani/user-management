package com.digipay.usermanagement.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="ROLE")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title")
    private String title;
    @ManyToMany
    @JoinTable(name ="ROLE_PERMISSION", joinColumns = { @JoinColumn(name ="role_id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id")})

    private Set<Permission> permissions;

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
