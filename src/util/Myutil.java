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
    //����
    public static Connection getConn(){
        //��һ��������������(������쳣�����׳��쳣����ʹ��try..catch..���鴦��)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("�������سɹ�");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("���������ʧ�ܡ�");
            /**
             *  ������ܱ���ClassNotFoundException
             *  ����ԭ�򣺿����������������ƴд����Ҳ����������Ҫ��jar��û�е���
             */
        }
        //�ڶ�������ȡ���Ӷ���
        String url = "jdbc:mysql://localhost:3306; DatabaseName=cqc305";
        String  username = "root";
        String  password = "813318";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("��������سɹ�");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("���Ӷ����ȡʧ�ܡ�");
        }
        //����һ�����Ӷ���
        return conn;
    }
    //������������ķ���
    public static Statement getSta(){
        try {
            sta=getConn().createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return sta;
    }
    //���ز�ѯ����ķ���
    public static ResultSet getRs(String sql){
        try {
            rs = getSta().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    //������ɾ�Ľ���ķ���
    public static int get(String sql){
        try {
            n = getSta().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
           /* JOptionPane.showMessageDialog(null,"����ʧ�ܣ������ظ�");*/
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
