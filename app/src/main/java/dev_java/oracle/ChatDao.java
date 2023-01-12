package dev_java.oracle;
//클래스 설계에 있어서 DAO패턴의 사용은 필수가 되었다.

//특히 MyBatis와 같은 ORM솔루션이 제공되면서 더 강조되었다.

import java.sql.CallableStatement;
import java.sql.Connection;

import dev_java.util.DBConnection_2;

public class ChatDao {// dataaccessobject
    Connection con = null;
    CallableStatement cstmt = null;
    DBConnection_2 dbMgr = new DBConnection_2();
    //DBConnection_2 dbMgr = new DBConnection_2("kiwi","123");

    public String login(String mem_id, String mem_pw) {
        String mem_name = null;
        try {
            con = dbMgr.getConnection("kiwi","123");// 물리적으로 떨어져있는 오라클서버와 연결통로
            //con = dbMgr.getConnection("kiwi","tiger");// 물리적으로 떨어져있는 오라클서버와 연결통로
            cstmt = con.prepareCall("{call proc_login(?, ?, ?)}");
            cstmt.setString(1, mem_id);
            cstmt.setString(2, mem_pw);
            cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
            cstmt.executeUpdate();
            mem_name = cstmt.getString(3);
            System.out.println(mem_name);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        return "mem_name";
    }

    public static void main(String[] args) {
        ChatDao cd = new ChatDao();
        
    String r_name = cd.login("banana", "123");
        System.out.println(r_name);

    }
}
