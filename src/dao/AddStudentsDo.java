package dao;

import com.window.studentsInfo;
import model.Selection;
import model.Students;
import util.Myutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddStudentsDo {
    private Connection conn=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    public List<Students> addStudents(){
        String sql="select * from S";
        List<Students> list=new ArrayList<Students>();
        try{
            conn= Myutil.getConn();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            System.out.println(ps.toString());
            while(rs.next()){
                Students addS=new Students();
                addS.setSNO(rs.getString(1));
                addS.setSN(rs.getString(2));
                addS.setPro(rs.getString(3));
                addS.setSex(rs.getString(4));
                addS.setSPW(rs.getString(5));
                addS.setGrade(rs.getString(6));
                list.add(addS);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
