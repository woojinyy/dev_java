package dev_java.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dev_java.util.DBConnection;

import java.sql.DriverManager;


public class JDBCTest2 {
    /* 
    public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String _URL = "jdbc:oracle:thin:@192.168.10.78:1521:orcl11";
    public static String _USER = "scott";
    public static String _PW = "tiger";
    */
    Connection con = null;//
    PreparedStatement pstmt = null;//쿼리문
    ResultSet rs = null;//
    DBConnection dbMgr= new DBConnection();
    public String currentTime() throws Exception {
        con = dbMgr.getConnection();
        String sql = "select to_char(sysdate,'HH24:MI:SS') from dual";
        pstmt = con.prepareStatement(sql);//정적
        rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getString(1);
        }
        return "15:09:49";
    }
    public static void main(String[] args) throws Exception {
        JDBCTest jt = new JDBCTest();
        String ctime = jt.currentTime();
        System.out.printf("현재 시간은 %s 입니다.\n", ctime);
    }
}