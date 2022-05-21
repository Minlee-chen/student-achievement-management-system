package dao;

import model.Students;
import model.Teacher;
import util.Myutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddTeachersDo {
    private Connection conn=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    public List<Teacher> addTeachers(){
        String sql="select * from T";
        List<Teacher> list=new ArrayList<Teacher>();
        try{
            conn= Myutil.getConn();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            System.out.println(ps.toString());
            while(rs.next()){
                Teacher addS=new Teacher();
                addS.setTNO(rs.getString(1));
                addS.setTN(rs.getString(2));
                addS.setSex(rs.getString(3));
                addS.setTPW(rs.getString(4));
                addS.setDept(rs.getString(5));
                addS.setProf(rs.getString(6));
                list.add(addS);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
