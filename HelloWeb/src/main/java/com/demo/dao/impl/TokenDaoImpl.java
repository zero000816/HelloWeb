package com.demo.dao.impl;

import com.demo.dao.DaoCon;
import com.demo.dao.TokenDao;
import com.demo.entity.User;
import com.sun.deploy.security.SelectableSecurityManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TokenDaoImpl implements TokenDao {
    @Override
    public boolean addToken(String name, String token) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        DaoCon dao=new DaoCon();
        Connection con= dao.connection();
        if(this.findByName(name)!=null){
            String sql="update usertoken set token=? where name =?";

            try {
                ps=con.prepareStatement(sql);
                ps.setString(2,name);
                ps.setString(1,token);
                ps.executeUpdate();
                return true;
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        else{
            String sql="insert into usertoken value (null,?,?)";

            try {
                ps=con.prepareStatement(sql);
                ps.setString(1,name);
                ps.setString(2,token);
                ps.executeUpdate();
                return true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public String findByName(String name) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql = "select * from usertoken where name=?;";
        DaoCon dao=new DaoCon();
        Connection con= dao.connection();
        if(con==null){
            System.out.println("sql off");
        }
        else{
            System.out.println("sql on");
        }
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,name);
            rs=ps.executeQuery();
            while (rs.next()){
                return rs.getObject("token").toString();
            }
                return null;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteToken(String name) {
        return false;
    }
}
