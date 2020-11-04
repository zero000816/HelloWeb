package com.demo.dao.impl;

import com.demo.dao.DaoCon;
import com.demo.dao.UserDao;
import com.demo.entity.Access;
import com.demo.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    @Override
    public User findByName(String name) {
            PreparedStatement ps=null;
            ResultSet rs=null;
            String sql = "select * from user where name=?;";
            DaoCon dao=new DaoCon();
            Connection con= dao.connection();
            try {
                ps=con.prepareStatement(sql);
                ps.setString(1,name);
                rs=ps.executeQuery();
                Access access=null;
                while(rs.next()){
                    User user =new User();
                    user.setId(rs.getInt(1));
                    user.setName(name);
                    user.setPassword(rs.getString(3));
                    return user;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

    @Override
    public User createUser(User user) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql = "insert into user values(null,?,?) ;";
        DaoCon dao=new DaoCon();
        Connection con= dao.connection();
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()){
                user.setId(rs.getInt(1));
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    }

