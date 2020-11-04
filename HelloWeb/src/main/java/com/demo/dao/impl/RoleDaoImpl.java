package com.demo.dao.impl;
import com.demo.dao.DaoCon;
import com.demo.dao.RoleDao;
import com.demo.entity.Access;
import com.demo.entity.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoleDaoImpl implements RoleDao {

    @Override
    public Role findById(int rid) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql = "select * from role where rid=?;";
        DaoCon dao=new DaoCon();
        Connection con= dao.connection();
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,rid);
            rs=ps.executeQuery();
            Access access=null;
            while(rs.next()){
                Role role =new Role();
                role.setRid(rid);
                role.setName(rs.getString(2));
                role.setStatus(rs.getInt(3));
                return role;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
