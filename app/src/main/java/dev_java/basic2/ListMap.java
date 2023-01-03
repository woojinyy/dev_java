package dev_java.basic2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import dev_java.tables.DeptVO;
import dev_java.util.DBConnection;
import java.util.Map;

public class ListMap {
    DBConnection dbMgr = new DBConnection();
    Connection con = null;// 오라클 서버와 연결통로 확보
    PreparedStatement pstmt = null;// 자바에서 오라클서버로 DML전달
    ResultSet rs = null;// 오라클 테이블에 제공되는 커서를 조작하는 함수제공

    public List<Map<String,Object>> getEmpList() {
        List<Map<String,Object>> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT                                              ");
        sql.append("empno,ename, dname                      ");
        sql.append("FROM emp,dept                                ");
        sql.append("WHERE emp.deptno=DEPT.deptno ");
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();// next previos isfirst islast
            list = new ArrayList<>();// 여기서 list.size()=0이다
            Map<String,Object> rmap = null;
            while (rs.next()) {
                rmap = new HashMap<>();
                rmap.put("empno", rs.getInt("empno"));// 디폴트 생성자 호출 0 null null
                rmap.put("ename", rs.getString("ename"));// 디폴트 생성자 호출 0 null null
                rmap.put("dname", rs.getString("dname"));// 디폴트 생성자 호출 0 null null
                /*
                 * System.out.println(rs.getInt("ename") + "," + rs.getInt("ename") + "," +
                
                 * rs.getString("dname"));
                 */
                list.add(rmap);// 0부터 차례대로 들어간다
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    



public static void main(String[] args) {
ListMap  listMap = new ListMap();
    List<Map<String,Object>> list = null;
        list= listMap.getEmpList();
        System.out.println("list :" + list);
        for (Map<String,Object> rmap : list) {
            // System.out.println(rdVO);
            System.out.println(rmap.get("empno")+","+rmap.get("ename")+","+rmap.get("dname"));
}
}



}
