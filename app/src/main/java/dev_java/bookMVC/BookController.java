package dev_java.bookMVC;

import java.util.List;
import java.util.Map;

//public class BookController implements Controller{  
public class BookController {
    // BookLogic bookLogic =new BookLogic();
    // 원래는 BookLogic클래스 객체주입해야 하지만 업무적인 깊이가
    // 얕아서 Logic클래스에서 선택,결정에 따른 추가적인 프로세스가 전혀 없는 상태
    // 따라서 컨트롤러 클래스와 DAO클래스 사이에 연결만 담당하니 의미없다
    BookDAO bookDao = new BookDAO();

    // 조회
    // SELECT bk_no,bk_title FROM book;
    // WHERE bk_title(' ㅇㅇㅇ'')=ㅇㅇㅇ
    // WHERE bk_author('dd')=dd
    public List<Map<String, Object>> getBookList(String cols, String keyword) {// 컬럼명과 키워드에 따라
        System.out.println("도서목록조회");
        List<Map<String, Object>> bList = null;

        bList = bookDao.getBookList(cols, keyword);
        return null;
    }

    // 입력
    // INSERT INTO dept (deptno,dname,loc) VALUES(67,'Q/C팀','부산');
    // 리턴타입 int
    public int bookInsert(BookVO bkVO) {
        System.out.println("도서정보 등록");
        int result = 0;
        result = bookDao.bookInsert(bkVO);
        return result;
    }

    // 수정
    // UPDATE UPDATE dept
    // SET loc ='대구'
    // WHERE deptno=66;
    // --리턴타입 int
    public int bookUpdate(BookVO bkVO) {
        System.out.println("도서정보 수정");
        int result = 0;
        result = bookDao.bookUpdate(bkVO);
        return result;
    }

    // 삭제
    // DELETE FROM book WHERE bk_no=5;
    // 리턴타입 int-return값이 1이면 삭제 성공 0 삭제실패
    // 파라미터타입 int-도서번호
    // PK만 있으면 삭제가 가능하다 BK_no
    public int bookDelete(int bk_no) {
        System.out.println("도서정보 삭제");
        int result = 0;
        result = bookDao.bookDelete(bk_no);
        return result;

    }
}
/*
 * SQL응용
 * JAVA와 ORCLE연동하기
 * 
 */