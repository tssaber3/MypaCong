package dao;

import entity.Picture;
import util.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//添加图片
public class pictureDao {
    public boolean addpicture(Picture picture) throws Exception {
        boolean bok = false;
        Connection connection = JDBC.getConnection();
        String sql = "insert into Picture values(?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,picture.getName());
        pstmt.setString(2,picture.getSrc());
        if(pstmt.executeUpdate()>0)
        {

            bok = true;
        }
        pstmt.close();
        return bok;
    }
    //根据名字的到图片地址
    public List serach(String name) throws Exception {
        List<String> list = new ArrayList<String>();
        Connection connection = JDBC.getConnection();
        String sql = "select src from picture where name=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,name);
        ResultSet resultSet = pstmt.executeQuery();
        while (resultSet.next())
        {
            String str = "";
            str = resultSet.getString("src");
            list.add(str);
        }
        resultSet.close();
        pstmt.close();
        connection.close();
        return list;
    }
    //显示数据库中name属性 且不重复
    public List show() throws Exception {
        List<String> list = new ArrayList<String>();
        Connection connection = JDBC.getConnection();
        String sql = "select DISTINCT name from picture";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery();
        while (resultSet.next())
        {
            String name = "";
            name = resultSet.getString("name");
            list.add(name);
        }
        resultSet.close();
        pstmt.close();
        connection.close();
        return list;
    }

}
