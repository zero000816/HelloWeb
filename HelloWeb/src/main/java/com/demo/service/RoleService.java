package com.demo.service;

import com.demo.entity.Access;

import java.util.Set;

public interface RoleService {
    Set<Access> getAllAccess(int rid);
}
