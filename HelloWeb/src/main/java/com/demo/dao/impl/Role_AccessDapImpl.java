package com.demo.dao.impl;

import com.demo.dao.DaoCon;
import com.demo.dao.Role_AccessDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Role_AccessDapImpl implements Role_AccessDao {
    @Override
    public List<Integer> findAllAidByRid(int rid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DaoCon dao= new DaoCon();
        Connection con=dao.connection();
        String sql = "select aid from role_access where rid=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,rid);
            rs = ps.executeQuery();
            List<Integer> list = new ArrayList<>();
            while (rs.next()){
                list.add(rs.getInt(1));
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
