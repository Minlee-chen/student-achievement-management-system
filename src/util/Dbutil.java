package util;

import java.sql.*;

public class Dbutil {
   public static String jdbcName = "mysql-connector-java-8.0.16.jar";//????????????
	public static String dbURL = "jdbc:mysql://localhost:3306;DatabaseName=cqc305"; //?????????????????
	public static String dbUserName="root";//?????????
	public static String dbPassWord="813318";//???????????
	public static Connection con=null;
    
    
    /**
     * ?????????
     */
    public static Connection getcon()throws Exception {
			try{
				Class.forName(jdbcName);
				con = DriverManager.getConnection(dbURL, dbUserName, dbPassWord);
			}catch (Exception e){
				e.printStackTrace();
			}
			return con;
	}
    /**
     * ????????
     */
    public static void closeCon(ResultSet rs,Statement stmt,Connection con)throws Exception{
    	try{
			if(con!=null) {
				con.close();
			}
		}catch (SQLException e){
    		e.printStackTrace();
		}

		if(rs!=null)
		{
			try{
				rs.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}

		if(stmt!=null)
		{
			try{
				stmt.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}



	}
    public static void main(String[] args) {
		Dbutil dbutil=new Dbutil();
		try {
			dbutil.getcon();
			System.out.println("连接成功!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("连接失败!");
		}
	}
    }

