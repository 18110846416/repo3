package com.xiong.dao;

import com.xiong.pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginCountDao {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/javaee";
    private static final String USER = "root";
    private static final String PASS = "123456";
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存登录人数
     * @param count
     */
    public void save(int count) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            pstmt = conn.prepareStatement("update logincount set count = ?;");
            pstmt.setInt(1, count);
            pstmt.executeUpdate();

        }catch (Exception e) {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e1) {
                e.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    /**
     * 查询登录人数
     * @param
     */
    public int find() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;

        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            pstmt = conn.prepareStatement("select * from logincount");
            rs = pstmt.executeQuery();
            if(rs.next()) {
                count = rs.getInt(1);
            }

        }catch (Exception e) {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e1) {
                e.printStackTrace();
            }
            e.printStackTrace();
        }
        return count;
    }
}
