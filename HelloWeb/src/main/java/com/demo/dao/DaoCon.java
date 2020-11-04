package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DaoCon {
    String driverClass = "com.mysql.jdbc.Driver";
    String serverIp = "localhost";//主机名，一般默认localhost
    String databaseName = "HelloWeb";//数据库的名字
    String userName = "root";
    String pwd = "password";//数据库密码
    //String pwd="Zcy@000816";
    String jdbcUrl = "jdbc:mysql://"+serverIp+":3306/"+databaseName+"?serverTimezone=Asia/Shanghai&useSSL=true";
    Connection con=null;
    public Connection connection(){
        Connection con=null;
        try {
            //读取JDBC
            Class.forName(driverClass);
            //链接数据库
            con = DriverManager.getConnection(jdbcUrl,userName,pwd);
            this.con = con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;//返回Connection对象
    }
}
