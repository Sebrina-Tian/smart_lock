package com.cqjtu.wlw.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    public static String dbUrl="jdbc:mysql://129.28.57.67:3306/smart_lock?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8";
    public static String dbUserName="monster";//monster
    public static String dbPassword="lock";//lock
    public static String CLASSNAME="com.mysql.jdbc.Driver";
    /**
     * 静态加载驱动
     */
    static{
        try {
            Class.forName(CLASSNAME);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 获取对数据库的连接
     */
    public static Connection getConnection() throws SQLException {
        Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
        return con;
    }
    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
