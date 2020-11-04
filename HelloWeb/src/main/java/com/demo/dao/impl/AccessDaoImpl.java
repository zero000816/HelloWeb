package com.demo.dao.impl;

import com.demo.dao.AccessDao;
import com.demo.dao.DaoCon;
import com.demo.entity.Access;
import com.demo.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccessDaoImpl implements AccessDao {
    @Override
    public Boolean addAccess(Access access) {
        PreparedStatement ps=null;
        String name= access.getName();
        int level=access.getLevel();
        int status=access.getStatus();
        String sql="insert into user values(null,?,?,?)";
        DaoCon dao=new DaoCon();
        Connection con= dao.connection();
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setInt(2,status);
            ps.setInt(3,level);
            ps.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Access findByAid(int aid) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql = "select * from access where aid=?;";
        DaoCon dao=new DaoCon();
        Connection con= dao.connection();
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,aid);
            rs=ps.executeQuery();
            Access access=null;
            while(rs.next()){
                access=new Access(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
            }
            return access;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
