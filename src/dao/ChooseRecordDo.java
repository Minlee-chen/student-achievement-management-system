package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.window.studentsInfo;

import model.Selection;
import util.Myutil;

public class ChooseRecordDo {
    private Connection conn=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    public List<Selection> queryChooseRecord(){
        String sql="select SNO,C.CNO,CN  from SC inner join C on SC.CNO=C.CNO where SNO=?";
        List<Selection> list=new ArrayList<Selection>();
        try{
            conn=Myutil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setString(1,studentsInfo.textField.getText() );
            rs=ps.executeQuery();
            System.out.println(ps.toString());
            while(rs.next()){
                Selection sel=new Selection();
                sel.setSNO(rs.getString(1));
                sel.setCNO(rs.getString(2));
                sel.setCN(rs.getString(3));
                list.add(sel);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }


}
