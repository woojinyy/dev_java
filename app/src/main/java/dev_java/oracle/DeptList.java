package dev_java.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dev_java.util.DBConnection;
import dev_java.weak4.DeptVO;

public class DeptList {
    
    Connection con = null;//
    PreparedStatement pstmt = null;//쿼리문
    ResultSet rs = null;//
    DBConnection dbMgr= new DBConnection();
    public void getDeptList(){
        con = dbMgr.getConnection();
        String sql = "SELECT deptno, dname, loc FROM dept";
        try {
            pstmt = con.prepareStatement(sql);// 정적
            rs = pstmt.executeQuery();
            List<DeptVO> deptList = new ArrayList<>();
            DeptVO dVO = null;
            while (rs.next()) {
                

                

            }
        } catch (Exception e) {

        }
    }
    public static void main(String[] args) {
        DeptList deptList = new DeptList();
            deptList.getDeptList();
        
    }
}

