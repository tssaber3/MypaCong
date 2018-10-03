package dao;

import entity.User;
import util.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDao {
    //用于用户登录注册
    public boolean addUser(User user) throws Exception {
        boolean bok = false;
        Connection connection = JDBC.getConnection();
        String sql = "insert into user values(?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,user.getUsername());
        pstmt.setString(2,user.getPassword());
        if(pstmt.executeUpdate() > 0)
        {
            bok = true;
        }
        pstmt.close();
        connection.close();
        return bok;
    }
    //用于用户登录
    public boolean loginUser(User user) throws Exception {
        boolean bok = false;
        Connection connection = JDBC.getConnection();
        String sql = "select * from user where username=? and password=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,user.getUsername());
        pstmt.setString(2,user.getPassword());
        ResultSet resultSet = pstmt.executeQuery();
        if(resultSet.next())
        {
            bok = true;
        }
        resultSet.close();
        pstmt.close();
        connection.close();
        return bok;
    }

    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setUsername("1274243927");
        user.setPassword("ts145623");
        userDao Dao = new userDao();
        boolean bok =  Dao.loginUser(user);
        System.out.println(bok);
    }
}
