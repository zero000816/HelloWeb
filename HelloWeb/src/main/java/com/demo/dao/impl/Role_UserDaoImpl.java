package com.demo.dao.impl;

import com.demo.dao.DaoCon;
import com.demo.dao.Role_UserDao;
import com.demo.entity.Access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Role_UserDaoImpl implements Role_UserDao {
    @Override
    public int addRoleUser(int uid, int rid) {
        return 0;
    }

    @Override
    public List<Integer> findAllRidByUid(int uid) {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            DaoCon dao= new DaoCon();
            Connection con=dao.connection();
            String sql = "select rid from role_user where uid=?";
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1,uid);
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

    @Override
    public boolean deleteRoleUser(int uid, int rid) {
        return false;
    }
}
