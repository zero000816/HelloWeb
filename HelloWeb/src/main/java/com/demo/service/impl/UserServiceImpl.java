package com.demo.service.impl;

import com.demo.dao.*;
import com.demo.dao.impl.RoleDaoImpl;
import com.demo.dao.impl.Role_AccessDapImpl;
import com.demo.dao.impl.Role_UserDaoImpl;
import com.demo.dao.impl.UserDaoImpl;
import com.demo.entity.Role;
import com.demo.entity.User;
import com.demo.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserServiceImpl implements UserService {
    public boolean login(String username,String password) {
        UserDao userDao=new UserDaoImpl();
        User user=userDao.findByName(username);
        if(user==null){
            return false;
        }
        else if (!user.getPassword().equals(password)){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public Set<Role> getAllRoles(String name) {
        List<Integer> ridList=null;
        UserDao userDao=new UserDaoImpl();
        Role_UserDao role_userDao=new Role_UserDaoImpl();
        ridList=role_userDao.findAllRidByUid(userDao.findByName(name).getId());
        RoleDao roleDao=new RoleDaoImpl();
        Set<Role> roles=new HashSet<>();
        for (Integer rid:ridList){
            Role role=roleDao.findById(rid);
            if (role!=null){
                roles.add(role);
            }
        }
        return roles;
    }

    public boolean register(String username, String password) {
        UserDao userDao=new UserDaoImpl();
        User user=userDao.findByName(username);
        if (user==null){
            User tempUser=new User(0,username,password);
            user=userDao.createUser(tempUser);
            if(user!=null){
            return true;
            }
            return false;
        }
        else{
            return false;
        }

    }

    public void save(User user) {


    }
}
