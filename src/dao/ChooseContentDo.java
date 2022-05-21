package dao;

import com.window.studentsInfo;
import model.Course;
import util.Myutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChooseContentDo {
    private Connection conn=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    public List<Course> queryChooseContent(){
        String sql="select TC.CNO,CN,TN,TC.TNO from C INNER JOIN TC ON C.CNO=TC.CNO INNER JOIN T ON T.TNO=TC.TNO";
        List<Course> list=new ArrayList<Course>();
        try{
            conn= Myutil.getConn();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            System.out.println(ps.toString());
            while(rs.next()){
                Course cou=new Course();
                cou.setCNO(rs.getString(1));
                cou.setCN(rs.getString(2));
                cou.setTN(rs.getString(3));
                cou.setTNO(rs.getString(4));
                list.add(cou);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
