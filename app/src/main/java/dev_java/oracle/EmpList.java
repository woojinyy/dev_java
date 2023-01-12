package dev_java.oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev_java.util.DBConnection_2;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

//sys_refcursor 모든 RDBMS에서 제공되는 타입이 아니라 오라클에서만 제공되는 타입
public class EmpList {
    Connection con = null;//인터페이스 비벼지는 부분 연계 연동
    CallableStatement cstmt = null;//프로시저를 요청할 때 사용하는 인터페이스
    DBConnection_2 dbMgr = new DBConnection_2();
    ResultSet rs= null;
    OracleCallableStatement ocstmt=null;
    public List<Map<String,Object>> getEmpList(){
        List<Map<String, Object>> list=new ArrayList<>();
        try {
            con = dbMgr.getConnection("scott","tiger");// 물리적으로 떨어져있는 오라클서버와 연결통로
            //con = dbMgr.getConnection("kiwi","tiger");// 물리적으로 떨어져있는 오라클서버와 연결통로
            cstmt = con.prepareCall("{call my_proc(?)}");
            cstmt.execute();
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            //굳이 추가로 제공되는 클래스로 치환하는 것은 resultSet을 주입받는 메소드 호출이 필요하기때문에
            //resultset을 선언했으니까 ocstmt.getCursor(1)넣으면
           
            // callablesstatement에서는 getCursor()를 지원하지 않기 때문에 형전환 하였다
            ocstmt= (OracleCallableStatement)cstmt;
            
            rs= ocstmt.getCursor(1);
            Map<String,Object> rmap= null;//게으른 인스턴스화
            while(rs.next()){
                rmap= new HashMap<>();
                rmap.put("empno",rs.getInt(1) );
                rmap.put("deptno",rs.getInt(2) );
                rmap.put("ename",rs.getString(3) );
                //List에 맵 추가하기
                //컨셉 : 리스트에 튜플 추가  맵에 컬럼 추가
                list.add(rmap);
            }    
            //System.out.println(mem_name);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        return list;

    }
    //프로시저 안에서는 여러가지의 DML문을 한 번 서버에 접속한 상태에서
    //한번에 처리가 가능하다
    //commit, rolback 까지 가능함
    //자바로 꺼내서 처리하지 않고 프로시저 내부에서 비즈니스 로직(업무포함한프로세스)
    //처리가능 = 변수에 대한 활용과 제어문 사용 가능 굳이 자바와 오라클 사이에서
    //들어왔따 나갔다 할 필요가 없이 오라클 내부에서 프로시저가 자바가 해야할 일까지 커버가능


    public static void main(String[] args) {
        EmpList eList = new EmpList();
        List<Map<String,Object>>list =eList.getEmpList();
        System.out.println(list);
        
    }
}
