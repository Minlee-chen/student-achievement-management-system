package dao;

import com.window.studentsInfo;
import model.QueryScore;
import model.Selection;
import util.Myutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryScoreDo {
    private Connection conn=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    public List<QueryScore> queryScore(){
        String sql="select SN,S.SNO,SC.CNO,CN,Score FROM S INNER JOIN SC ON S.SNO=SC.SNO INNER JOIN C ON SC.CNO=C.CNO WHERE S.SNO=?";
        List<QueryScore> list=new ArrayList<QueryScore>();
        try{
            conn= Myutil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, studentsInfo.textField.getText() );
            rs=ps.executeQuery();
            System.out.println(ps.toString());
            while(rs.next()){
                QueryScore ques=new QueryScore();
                ques.setSN(rs.getString(1));
                ques.setSNO(rs.getString(2));
                ques.setCNO(rs.getString(3));
                ques.setCN(rs.getString(4));
                ques.setScore(rs.getFloat(5));
                list.add(ques);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

}
