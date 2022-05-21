package util;
import java.sql.DatabaseMetaData;
import javax.swing.*;
import java.sql.*;
public class Myutil {
    private static Connection conn;
    private static Statement sta;
    private static ResultSet rs;
    private static int n;
    private static int cr;
    private static ResultSet tabs;
    //声明
    public static Connection getConn(){
        //第一步：加载驱动类(如果有异常，则抛出异常或者使用try..catch..语句块处理)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动类加载失败。");
            /**
             *  这里可能报错：ClassNotFoundException
             *  错误原因：可能是驱动类的名称拼写错误，也可能是所需要的jar包没有导入
             */
        }
        //第二步：获取连接对象
        String url = "jdbc:mysql://localhost:3306; DatabaseName=cqc305";
        String  username = "root";
        String  password = "813318";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("连接类加载成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("连接对象获取失败。");
        }
        //返回一个连接对象
        return conn;
    }
    //创建操作对象的方法
    public static Statement getSta(){
        try {
            sta=getConn().createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return sta;
    }
    //返回查询结果的方法
    public static ResultSet getRs(String sql){
        try {
            rs = getSta().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    //返回增删改结果的方法
    public static int get(String sql){
        try {
            n = getSta().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
           /* JOptionPane.showMessageDialog(null,"建表失败，表名重复");*/
            n=1;
        }
        return n;
    }
    public static void close(){
        try {
            if(rs != null){
                rs.close();
            }
            if(sta != null){
                sta.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
