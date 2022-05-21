package dao;

import com.window.studentsInfo;
import model.Grade;
import util.Myutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EntryScoreDo {
    private Connection conn=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    public List<Grade> entryScore(){
        //"教师号", "课程号", "课程名", "学号", "学生姓名", "成绩"
        String sql="SELECT TC.TNO,TC.CNO,CN,SC.SNO,SN,SCORE FROM S JOIN SC ON SC.SNO=S.SNO JOIN C ON C.CNO=SC.CNO JOIN TC ON C.CNO=TC.CNO where TNO=?;";
        List<Grade> list=new ArrayList<Grade>();
        try{
            conn= Myutil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setString(1,studentsInfo.textField.getText());
            rs=ps.executeQuery();
            System.out.println(ps.toString());
            while(rs.next()){
                Grade cou=new Grade();
                cou.setTNO(rs.getString(1));
                cou.setCNO(rs.getString(2));
                cou.setCN(rs.getString(3));
                cou.setSNO(rs.getString(4));
                cou.setSN(rs.getString(5));
                cou.setScore(rs.getFloat(6));
                list.add(cou);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

}
