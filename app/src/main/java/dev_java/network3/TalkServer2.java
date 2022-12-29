package dev_java.network3;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//선언과 생성을 분리하는 코딩 전개
//자바는 단일상속만 가능함
//자바는 단일상속의 단점을 보완하기 위해 인터페이스는 다중으로 처리가능함(구현체클래스)
public class TalkServer2 extends JFrame implements ActionListener {//Runnable 삭제 -스레드 없으면 어케되는지 알아보기위해 
    //스레드가 하나라고 대기탄다고 손님이 안와 어쾀???????????????????????????????????????????????????????????????????????????????????????????????????????????????????
    //싱글스레드 문제점 일이 진행이 안돼 가만히 있는거야 멍때리고 가지도않고 비켜주지도않으면서 자리차지하고 있는거지 근데 죽은건 아니야 또 살아는 있어 시스템이 앱이 죽은건 아니야
    //그냥 가만히 있는거야 우두커니 답답하겠죠? 어쾀?????????????? 껏다킨다  껏다키면 뭐하나 구조가 순서가 틀려먹었는데
    // 선언부
    // 클라이언트측에서 new Socket하면 그 소켓정보를 받아서 쓰레드로 넘김
    TalkServerThread2 tst = null;
    // 동시에 여러명이 접속하니까 List - Vector<>(); 멀티스레드 안전, 속도 느림
    List<TalkServerThread2> globalList = null;// Q.누구를 관리할거야? A.클라이언트(여러명)소켓
    ServerSocket server = null;
    Socket socket = null;
    JTextArea jta_log = new JTextArea(10, 30);
    JScrollPane jsp_log = new JScrollPane(jta_log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JButton jbtn_log = new JButton("로그저장");

    // 생성자
    public TalkServer2() {
        // initDisplay();//시점문제- 스케쥴링
    }

    // 화면그리기
    public void initDisplay() {
        jbtn_log.addActionListener(this);
        this.add("North", jbtn_log);
        this.add("Center", jsp_log);
        this.setSize(500, 400);
        this.setVisible(true);
    }

    // thread가 두개이다 화면 요청과 start()순서를 바꾸더라도 각자 처리된다.
    public static void main(String[] args) {// 내안에 run메소드가 재정의(override) 되어 있으니까//
        TalkServer2 ts = new TalkServer2();// 스레드 생성시 파라미터로 TalkServer객체를 넘김
        ts.initDisplay();//화면이 먼저냐 init이 먼저냐 그것이 문제로다 init이 먼저면 화면도 안떠 runnable없으면 싱글스레드잖아 
        ts.init();//나는 서버 -> 대기한다  언제까지? Client 올 때까지
       // Thread th = new Thread(ts);//Runnable을 implements에서 제거했기 때문에 
        // thread pool에 있는(ready상태) (상속받은,implements한)thread중에서 우선순위를 따지고 차례로 입장한다
       // th.start();// 46번 호출됨 - 지연발생함 - 클라이언트가 접속할때까지 기다림...
    }

    // 서버소켓과 클라이언트 소켓을 연결
    //@Override // 오버라이드가 성립이 되려면 인터페이스의 구현체클래스가 되어야 하는데 runnable을 삭제해서 쓸모가 없다
    public void init() { // public int run()안된다고 반환타입 건드리지 말라고 
        // 서버에 접속해온 클라이언트 스레드 정보를 관리할 벡터 생성하기
        // 벡터는 멀티스레드에서 안전-서버에 동시접속자 수가 여러명이라 벡터 안에는 클라이언트를 관리하는 스레드를 추가해야 한다;
        // 스레드는 메세지를 듣고, 들은 내용을 그대로 클라이언트측에 내보낸다(지어내면 안돼)
        // 200#토마토#오늘스터디할까? String Tokenizer st =new StringTokenizer("",#);
        // st,nextToken():String-200
        // st,nextToken():String-토마토 닉네임
        // st,nextToken():String-오늘 스터디 할까? 메세지 -프로토콜 설계
        globalList = new Vector<>();// 멀티스레드안전해서 ArrayList대신 사용함
        boolean isStop = false;
        try {// 네트워크는 항상 장애가 있다. 예외처리 해야한다 예외가 발생할 가능성이 있는 코드를 넣는다
             // Q. run메소드는 언제 호출 되나요?
             // A. Thread인스턴스변수.start(); 요청시

            // Q.왜 이렇게 함?
            // A.여러 Thread가 존재하고 경합이 벌어진다 우선순위를 따져가며 호출

            // Q.반드시 run메소드를재정의 해야 할까요?
            server = new ServerSocket(8839);// 서버포트번호 설정하기
            jta_log.append("Server Ready.........\n");// 대기 탐 - 멈춤 - wait
            while (!isStop) {// 언제 진입? -> new Socket(서버의 ip.port)
                socket = server.accept();
                jta_log.append("client info:" + socket + "\n");
                jta_log.append("client info:" + socket.getInetAddress() + "\n");
                //TalkServer=this
                //아래 객체를 생성하는 것과 동시에 생성자를 호출하는 데 클래스 이름을 TalkServer2로 바꿈 따라서 에러발생
                //해결방법 TalkServerThread의 생성자 파라미터 타입을 TalkServer2로 변경
                TalkServerThread2 tst = new TalkServerThread2(this);// TalkServer2
                 //String -VARCHR2, CHAR, int ~number(5):9999 double-number(7.2) 99999.99
                //다른 언어간 데이터 공유(static) 목적으로 설계하는 디자인 패턴이름 DTO(data transfer object)인스턴스화 하지 않는다 
                //DeptVO-this 전역변수 초기화 ValueObject패턴일부 -오라클과 자바의 연동에 필요
                //ActionListener구현 버튼.addActionListener(this) 이벤트 처리시 이벤트 처 리를 담당하는 클래스(핸들러클래스)를 가리키는 목적으로 
                //new XXXX(this) 클래스 분리, 나눌 때 MVC패턴으로 구현할 때
                //생성자 호출 시 파라미터로 들어오는 this는 현재 인스턴스화 된 객체를 가리킨다
               // TalkServerThread2 tst = new TalkServerThread2(super);// super는 상위 프레임 
                //TalkServer가 화면을 만들 때 JFrame상속받았다.
               
                tst.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//////////////////////// [[ end of run ]] /////////////////////////

    @Override
    public void actionPerformed(ActionEvent e) {
        // 로그를 파일로 저장하기

    }
}
/*
 * 채팅서버 구축
 * 클라이언트에서 접속하면 접속해온 정보를 서버측화면에서 볼 수 있다.(JFrame 상속했다=로그를남겼다)
 * 자바는 단일 상속만 가능 -> 인터페이스로 지원한다(다중상속O)-> 다중인터페이스 구현체는 가능하다
 * 스레드를 구현하는 방법에는 1) Thread 상속 2)Runnable 인터페이스 implements하기
 * 현재 TalkServer는 JFrame을 상속받고 있어서 Runnable을 implements했음 (ex. extends JFrame
 * implements Runnable, ActionListener)
 * class TalkServer 상속 다음에 클래스 두개 못한다구요(ex. class Talksever extends
 * JFrame,Thread{} (X))
 * 상속을 받거나 implements하면 부모클래스나 인터페이스가 정의하고 있는 메소드를 재정의 할 수 있다.
 * (overriding 선언부는 완전 일치해야한다)
 * 인터페이스는 오직 추상메소드만 갖는다-Runnable도 추상메소드 있다
 * 그게 run메소드 이다.
 */
//POJO F/W설계 인터페이스 중심코딩전개수업 Spring boot(전자정부프레임워크)기반 MVC패턴수업진행
//자바스크립트(ES5,6,7소개)-NodeJS
//리액트(객체,클래스,리액트훅,메소드,파라미터,리턴타입)

/*
 * 순서가 있다 무조건 스레드를 써야해요 잘 몰라도 쓰지않으면 서비스가 진행이 안된다
 * ts.init는 스레드가 없다고 
 */