package dev_java.bookMVC;

import java.util.List;
import java.util.Map;

public class BookDAO {
    /*******************************************************
     * 도서정보삭제구현
     * @param bk_no <=도서번호
     * @return  1이면 삭제 성공 0ㅇ이면 실패
     *******************************************************/
    public int bookDelete(int bk_no) {
        int result =0;
        System.out.println("bookDelete호출(사용자가 선택한도서번호)"+bk_no);
        //insert here

        return result;
    }//end of bookDelete

/*********************************************************
 * 도서정보 수정구현
 * @param bkVO
 * @return
 **********************************************************/
    public int bookUpdate(BookVO bkVO) {
        //롬복 어노테이션 @Data를 사용했기에 getter/setter메소드는 없지만 사용가능
        //단 VO타입이므로 전역변수에 담긴 값을 출력하려면 getter메소드 호출함
        //전역변수는 캡슐화로 인해 직접 접근 불가위변조로 인한 피해로부터 보호위해 사용되지 않음
        //접근제한자는 반드시 private으로 할 것
        System.out.println("bookUpdate호출(사용자가 선택한 도서정보 주소번지출력됨)"+bkVO);
        int result =0;
        return result;
    }//end of bookUpdate

/***********************************************************
 * 도서정보 입력 구현
 * @param bkVO-입력요청으로 입력받은 값
 * @return-1이면 입력 성공 0이면 입력 실패
 ************************************************************/
    public int bookInsert(BookVO bkVO) {
        System.out.println("bookInsert호출"+bkVO);
        int result =0;
        return result;
    }//end of bookInsert

/************************************************************
 * 도서목록조회
 * @param cols 컬럼명 bk_title or bk_author or bk_info
 * @param keyword 텍스트필드에 사용자가 입력한 값
 * @return 검색결과는 n개 로우 List<Map<>>
 * 조인이 필수인경우 반드시 List<Map>형태가 유리
 * 그렇지 않은 경우 List<XXXXXVO>형태와 별 차이 없다
 * 단 조회결과로 얻은 정보를 자바코드에서 연산해야하는 경우
 * 제네릭 타입으로 Map보다는 XXXVO가 유리하다 
 * 전역변수에는 타입이 붙는다 
 * Map이면 리턴값이 무조건 Object 이다 ClassCastingException 조심
 * int i = integer.parseInt(pMap.get("bk_no").toString())
 * int i = xxxVO.getBkno();
 *************************************************************/
    public List<Map<String, Object>> getBookList(String cols, String keyword) {
        return null;
    }
    
}