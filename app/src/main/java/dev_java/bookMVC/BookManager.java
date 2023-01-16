package dev_java.bookMVC;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookManager extends JFrame implements ActionListener {
    // 개발 방법론에서 디자인 패턴 중 MVC패턴을 알아보자
    // M : 모델계층 (ex. XXXLogic.java+XXXDAO.java)=> 서비스계층=비지니스 로직(업무내용)계층
    // XXXDAO의 유무는 MVC패턴에 영향이 없다.
    // 단, 오라클 서버와 연계에 반복되는 코드를 줄여주고 오픈소스나
    // 라이브러리(iBatis,MyBatis,Hibernate)를 조립하기 위한
    // Hibernate SQL문이 없는 완전자동형
    // MyBatis 반자동형
    // 클래스 쪼개기(강조점: 생성자)-> POJO(pure 어떠한것도 implements하고있지 않은) -> Spring(maven) ->
    // Springboot(Gradle) 완결
    // 요구사항으로 만들어 사용하는 클래스이다
    // V : 뷰계층
    // C : 컨트롤 계층
    // 프레임 워크를 원하는 이유 - 1. 실력차이를 줄여준다 숙련 비숙련자 gap을 줄여
    // 틀이 정해짐-클래스 선언,메소드 선언 다 되어있음(단 파라미터의 타입,개수는 내가 결정)
    // 개발자는 비지니스 로직에만 집중
    public BookManager() {
        // initDiplay를 생성자안에서 호출할 때 : 속지(JPanel,JScrollPane)로 사용되는 페이지일 때
        // 요청에 따른 페이지 갱신처리, 화면갱신, 화면 초기화는 생성자 안에 파라미터로 두는 게 일반적 큰 문제 일으키지 않으면서
        // 화면 갱신 초기화 갱신처리 이슈를 해결할 수 있는 가장 기본적인 컨셉이다
        // 그러나 스레드 구현시에는 이슈가 발생하니까 주의해야 한다.
        // 논리에러-> 트러블슈팅 NullPointException
        //
    }// 클래스 쪼개기 ,MVC는 화면과 로직의 분리를 위해 나온 컨셉
    // 선언부
    // 이른인스턴스화 선언 //오라클 연계

    JButton jbtn_sel = new JButton("조회");// SELCET문
    JButton jbtn_ins = new JButton("입력");// INSERT문
    JButton jbtn_upd = new JButton("수정");// UPDATE문
    JButton jbtn_del = new JButton("삭제");// DELETE문
    JButton jbtn_board = new JButton("게시판");//
    // 버튼 붙일 속지
    JPanel jp_north = new JPanel();
//전역변수 선언
String gubun= "bookMgr";//디폴트로 bookMgr을 선언 도서crud이면 bookMgr 게시판 crud이면 boardMgr
    // 화면 그리기
    public void initDisplay() {
        // 이벤트 소스와 이벤트 처리클래스 맵핑하기
        jbtn_sel.addActionListener(this);
        jbtn_ins.addActionListener(this);
        jbtn_upd.addActionListener(this);
        jbtn_del.addActionListener(this);
        jbtn_board.addActionListener(this);

        jp_north.add(jbtn_sel);
        jp_north.add(jbtn_ins);
        jp_north.add(jbtn_upd);
        jp_north.add(jbtn_del);
        jp_north.add(jbtn_board);
        this.add("North", jp_north);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setVisible(true);
        this.setTitle("도서관리 시스템 Ver1.0");
        this.setLocation(100, 100);

    }

    public static void main(String[] args) {
        BookManager bManager = new BookManager();
        bManager.initDisplay(); // 리펙토링-설계 디자인패턴
        // initDiplay를 메인에서 호출할 때 : 메인스레드와 Runnable을 통해서 구현하는
        // 스레드를 분리 할 수 있는 경우에 사용
        // 메인 스레드와 자기자신이 runmethod 구현체 클래스 역할을 병행하는 컨셉일 때
        // 지연발생 방지 소켓 accept 병렬처리가 중요하다

    }// 메인 끝
     // 왜 재정의하는건가??
     // 아이폰?갤럭시? 아이패드? 갤탭? 장치마다 결정되지 않았으니까
     // 하드웨어가 있을 때 소프트웨어가 빛을 밝힌다

    @Override
    public void actionPerformed(ActionEvent e) {
        // 입력|수정|삭제|조회 버튼 클릭이벤트를 JVM이 감지
        
        // 감지되면 JVM이 action Performed 메소드를 알아서 호출=callback함수
        Object obj = e.getSource();
        BookController bookController=null;
        BoardController boardController=null;
        if(obj==jbtn_board){
            gubun="boardMgr";//gubun의 디폴트값이 bookMgr
            if("boardMgr".equals(gubun)){//이벤트 변수가 게시판일때
                boardController=(BoardController)FrontController.getController(gubun);
                System.out.println("게시판선택"+boardController);    
                //게시판 컨트롤러가 결정되면(클릭되면) 다시 디폴트값 초기화
                gubun="bookMgr";
    
            }

        }
        //도서관리crud
        else if("bookMgr".equals(gubun)){ //파라미터로 가져와야하니? 선언을 하고 가져와야하니?
            bookController=(BookController)FrontController.getController(gubun);
        System.out.println("도서관리 선택"+bookController);  //선언을 먼저해야 하는데 전역변수로?지역변수로?
                                                            //기준을 도서관리로 잡고 전역변수로 지정하자
             // if문은 무조건 조건을 따진다
            if (obj == jbtn_sel) {// 조회버튼클릭
                System.out.println("조회");
            }
            // else if문은 앞조건(if)을 수렴하면 뒤에있는 코드는 실행하지않는다
            else if (obj == jbtn_ins) {// 입력버튼
                System.out.println("입력");
            } else if (obj == jbtn_upd) {// 수정버튼
                System.out.println("수정");
            } else if (obj == jbtn_del) {// 삭제버튼
                System.out.println("삭제");
            }
        
        }//도서관리 끝

    

    }// 오버라이드 끝
}


/*
* BookManager.java
 *  main 메소드 존재
 * 버튼이 클릭 되었을 때 BookController주입 받을 건지
 * 아니면 BoardController주입 받을지 결정
 * 의사결정자는 사용자
 * 사용자가 선택한 정보를 넘기는 방법은 파라미터
 * 변수를 뭐로 할 것인지 결정하자
 * String gubun = "bookMgr" or "boardMgr"
 * 
 * 이와같은 역할을 맡을 클래스를 설계해보자
 * FrontController
 * 
 * 조회|수정|삭제|입력-BookController로 연결
 */