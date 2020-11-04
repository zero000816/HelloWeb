package com.demo.service;

import com.demo.entity.Role;
import com.demo.entity.User;

import java.util.Set;

public interface UserService {
    boolean login(String username,String password);
    boolean register(String username,String password);
    void save(User user);
    Set<Role> getAllRoles(String name);

}
