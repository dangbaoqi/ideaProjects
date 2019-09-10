package mysql;

import java.sql.*;

public class MysqlDemo {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dbq?useSSL=false&serverTimezone=UTC";
    static final String username = "root";
    static final String password = "123456";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            //注册驱动
            Class.forName(JDBC_DRIVER);
            System.out.println("连接数据库...");
            //创建连接
            conn = DriverManager.getConnection(DB_URL,username,password);
            //获取PreparedStatement对象
            String sql = "SELECT * FROM T_USER";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("username");
                String pw = rs.getString("password");
                System.out.println("id:"+id+"\t用户名:"+name+"\t密码:"+pw);

            }
            rs.close();
            ps.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("异常"+e.getMessage());
        }
        System.out.println("GoodBye!");
    }
}
