package com.p5.adoptions.model;

import com.p5.adoptions.repository.roles.Role;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {
    protected Integer id;
    private String password;
    private String email;
    private Set<Role> userRoles = new HashSet<>();

    public Set<Role> getUserRoles() {
        return userRoles;
    }

    public UserDTO setUserRoles(Set<Role> userRoles) {
        this.userRoles = userRoles;
        return this;
    }

    public UserDTO(Integer id, String password, String email, Set<Role> roles) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.userRoles = roles;
    }

    public UserDTO() {
    }

    public Integer getId() {
        return id;
    }

    public UserDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }
}
