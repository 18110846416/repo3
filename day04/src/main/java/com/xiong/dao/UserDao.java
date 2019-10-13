package com.xiong.dao;

import com.xiong.pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

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
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    public User findByUsernameAndPassword(String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = new User();

        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            pstmt = conn.prepareStatement("select * from user where username = ? and password = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
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
            return null;
        }
        return user;
    }


    /**
     * 保存用户
     * @param user
     */
    public void save(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            pstmt = conn.prepareStatement("insert into user (username, password) values (?,?)");
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
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
     * 查询所有
     * @return
     */
    public List<User> findAll() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<User>();

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
            pstmt = conn.prepareStatement("select * from user");
            rs = pstmt.executeQuery();

            while(rs.next()) {
                User u = new User();
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setPassword(rs.getString(3));
                list.add(u);
            }
            return list;
        } catch (Exception e) {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e1) {
            }
            e.printStackTrace();
        }
        return list;
    }

}
