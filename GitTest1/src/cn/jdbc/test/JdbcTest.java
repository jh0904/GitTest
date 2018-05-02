package cn.jdbc.test;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class JdbcTest {
        private static final String DRIVER="com.mysql.jdbc.Driver";
        private static final String URL="jdbc:mysql://localhost:3306/jh";
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
        } catch (SQLException e) {
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
        ResultSet rs = t.query ("select * from orders");
        List<Date> list=new ArrayList<Date> ();
        try {
            while (rs.next()){
                int order_num= rs.getInt ("order_num");
                Date order_date = rs.getDate ("order_date");
                int cust_id=rs.getInt ("cust_id");
                list.add (order_date);
                System.out.println (order_num+"----"+order_date+"-----"+cust_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Date d: list) {
            System.out.println (d);
        }
        System.out.println ("-------------");
        long time = list.get (list.size ()-1).getTime ();
        long time1 = list.get (0).getTime ();
        System.out.println ("time----"+time);
        System.out.println ("time1----"+time1);
        long tt=time-time1;
        System.out.println (tt);
        long l = tt/1000/60/60/24;
        System.out.println (l);

    }
}
