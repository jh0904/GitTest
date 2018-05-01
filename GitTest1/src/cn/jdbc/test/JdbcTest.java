package cn.jdbc.test;

import java.sql.*;

public class JdbcTest {
        private static final String DRIVER="com.mysql.jdbc.Driver";
        private static final String URL="jdbc:mysql://localhost:3306/magic";
        private static final String NAME="root";
        private static final String PWD="root";
        //创建连接数据库所需的接口
        private Connection conn=null;
        private Statement st=null;
        private ResultSet rs=null;
    //与数据库建立连接的方法
    public Connection getConn(){
        //加载驱动
        try {
            Class.forName(DRIVER);
            conn=DriverManager.getConnection(URL,NAME,PWD);
            System.out.println("-----------------"+conn);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
    //公共的查询的方法
    public ResultSet query(String sql){
        conn=getConn();
        try {
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //增加，删除，更改影响都是行
    public int update(String sql){
        conn=getConn();
        int row=0;
        try {
            st=conn.createStatement();
            row=st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public static void main(String[] args) {
        JdbcTest t=new JdbcTest();
        ResultSet rs = t.query ("select * from user");
        try {
            while (rs.next()){
                int id = rs.getInt ("id");
                String name = rs.getString ("name");
                String age=rs.getString("age");
                System.out.println (id+"----"+name+"-----"+age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
