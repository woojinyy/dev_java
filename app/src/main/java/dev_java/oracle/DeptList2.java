package dev_java.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dev_java.util.DBConnection;
import dev_java.weak4.DeptVO;

public class DeptList2 {

    Connection con = null;//
    PreparedStatement pstmt = null;// 쿼리문
    ResultSet rs = null;//
    DBConnection dbMgr = new DBConnection();

    public List<DeptVO> getDeptList() {
        con = dbMgr.getConnection();
        String sql = "SELECT deptno, dname, loc FROM dept";
        List<DeptVO> deptList = new ArrayList<>();
        try {
            DeptVO dVO= null;
            pstmt = con.prepareStatement(sql);// 정적
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                dVO.setDeptno(rs.getInt("deptno"));
                dVO.setDname(rs.getString("dname"));
                dVO.setLoc(rs.getString("loc"));
               //dVO=DeptVO.builder().deptno(rs.getInt("deptno")).dname(rs.getString("dname")).loc(rs.getString("loc")).build();
                deptList.add(dVO);//에드하자 주소번지
            }
        } catch (Exception e) {
        }
        return deptList;
    }


    public static void main(String[] args) {
        DeptList2 deptList = new DeptList2();
        List<DeptVO> list =null;
        list =deptList.getDeptList();
        for(DeptVO rdVO:list){
        System.out.println(rdVO.getDeptno()+rdVO.getDname()+rdVO.getLoc());
        deptList.getDeptList();
    }
    for(int i =0;i<list.size();i++){
        DeptVO rdVO=list.get(i);
        System.out.println(rdVO);
    }
}
}