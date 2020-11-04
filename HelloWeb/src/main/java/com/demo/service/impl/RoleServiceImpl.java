package com.demo.service.impl;

import com.demo.dao.AccessDao;
import com.demo.dao.RoleDao;
import com.demo.dao.Role_AccessDao;
import com.demo.dao.impl.AccessDaoImpl;
import com.demo.dao.impl.Role_AccessDapImpl;
import com.demo.entity.Access;
import com.demo.service.RoleService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoleServiceImpl implements RoleService {
    @Override
    public Set<Access> getAllAccess(int rid) {
        Set<Access> accesses =new HashSet<>();
        List<Integer> aidList=null;
        Role_AccessDao role_accessDao=new Role_AccessDapImpl();
        aidList=role_accessDao.findAllAidByRid(rid);
        AccessDao accessDao=new AccessDaoImpl();
        for(Integer aid:aidList){
            Access access=accessDao.findByAid(aid);
            if(access!=null){
                accesses.add(access);
            }
        }
        return accesses;
    }
}
