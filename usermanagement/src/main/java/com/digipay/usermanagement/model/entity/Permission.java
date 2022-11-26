package com.digipay.usermanagement.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="PERMISSION")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permissionTitle='" + title + '\'' +
                '}';
    }
}
