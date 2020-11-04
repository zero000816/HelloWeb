package com.demo.dao;

import com.demo.entity.User;

public interface UserDao {
    User findByName(String name);
    User createUser(User user);
}
