package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {
    public static final String Driver="com.mysql.jdbc.Driver";
    public static final String url="jdbc:mysql://localhost:3306/picture?serverTimezone=GMT";
    public static final String dbname="root";
    public static final String pwd="ts145623";
    public static Connection getConnection()
    {
        Connection connection = null;
        try {
            Class.forName(Driver);
            connection = DriverManager.getConnection(url,dbname,pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("连接成功");
        return connection;
    }
    //释放资源
    public static void close(Connection conn){

        try {
            if(conn!=null){
                conn.close();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println(JDBC.getConnection());
    }
}
