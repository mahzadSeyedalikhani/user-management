package com.digipay.usermanagement.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String username;

    @Column(name="national_code")
    private int nationalCode;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public void setUsername(String username) {
         this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }

    public int getNationalCode() {
        return nationalCode;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nationalCode=" + nationalCode +
                ", role=" + role +
                '}';
    }
}
