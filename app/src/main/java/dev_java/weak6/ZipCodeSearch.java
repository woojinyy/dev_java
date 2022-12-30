package dev_java.weak6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dev_java.util.DBConnection;

public class ZipCodeSearch {
    Connection con = null;//인페 결합도 낮아 의존성 낮아 독립성 높아 
    PreparedStatement pstmt=null;//인페
    ResultSet rs= null;//인페
    DBConnection dbMgr= new DBConnection();
    //우편번호 검색기 만들기
    public Integer[] getZipcode(String dong){//여러개의 같은 타입-> 배열써야해
        System.out.println("getzipcode호출 성공=====>"+dong);
        Integer[] zipcodes= null;
        //List<Integer> imsi = new ArrayList<>();//구현체가 arraylist
        Vector<Integer> imsi = new Vector<>();//구현체가 arraylist

        StringBuilder sql = new StringBuilder();//쿼리문을 담을때는 String 을 쓰지 않습니다.
        ///////////StringBuilder쓰세요//////////
        sql.append("SELECT ");
        sql.append("zipcode ");
        sql.append("FROM zipcode_t ");
        sql.append("WHERE dong LIKE ?||'%' ");
////////////////////////////////////////////////////////
        try {//서버가 고장났을 수도 있잖아
            con=dbMgr.getConnection();//메소드 호출로 커넥션 주입 해준다
            //쿼리문을 오라클서버에 전달할 전령 
            pstmt=con.prepareStatement(sql.toString());//스트링만 올 수 있따.
            pstmt.setString(1,dong);
            rs=pstmt.executeQuery();
            while(rs.next()){//배열에 담을건데 사이즈 어떻게 알아???????????????????????????????????????????????????????
                                            //몰루????????
                                            int code = rs.getInt("zipcode");
                                            
                                            //System.out.println(rs.getInt("zipcode"));
                                            imsi.add(code);
            }
            zipcodes = new Integer[imsi.size()];//배열의 크기(row의 수) 찾기
            imsi.copyInto(zipcodes);  //copyinto벡터에 있는거야  
            for(int c:zipcodes){
                System.out.println(c);
            }
        } catch (Exception e) {
            e.printStackTrace();//라인번호출력, 이력출력
        }finally{
            //사용 자원반납하기
            dbMgr.freeConnection(con, pstmt, rs);
        }
        return zipcodes;

    }
    /*
    public List<Integer> getZipcode2(String dong){//여러개-> 배열써야해
    

    }
    */
    public static void main(String[] args) {
        ZipCodeSearch zcs = new ZipCodeSearch();
        zcs.getZipcode( "역삼");
    }
}
