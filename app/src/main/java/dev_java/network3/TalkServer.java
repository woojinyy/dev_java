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
public class TalkServer extends JFrame implements Runnable, ActionListener {
	// 선언부
	//클라이언트측에서 new Socket하면 그 소켓정보를 받아서 쓰레드로 넘김
	TalkServerThread tst = null;
	//동시에 여러명이 접속하니까 List - Vector<>(); 멀티스레드 안전, 속도  느림
	List<TalkServerThread> globalList = null;// Q.누구를 관리할거야? A.클라이언트(여러명)소켓
	ServerSocket server = null;
	Socket socket = null;
	JTextArea jta_log = new JTextArea(10, 30);
	JScrollPane jsp_log = new JScrollPane(jta_log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JButton jbtn_log = new JButton("로그저장");

	// 생성자
	public TalkServer() {
		//initDisplay();//시점문제- 스케쥴링
	}

	// 화면그리기
	public void initDisplay() {
		jbtn_log.addActionListener(this);
		this.add("North", jbtn_log);
		this.add("Center", jsp_log);
		this.setSize(500, 400);
		this.setVisible(true);
	}
//thread가 두개이다 화면 요청과 start()순서를 바꾸더라도 각자 처리된다.
	public static void main(String[] args) {//내안에 run메소드가 재정의(override) 되어 있으니까//
		TalkServer ts = new TalkServer();//스레드 생성시 파라미터로 TalkServer객체를 넘김
		ts.initDisplay();
		Thread th = new Thread(ts);
        //thread pool에 있는(ready상태)  (상속받은,implements한)thread중에서 우선순위를 따지고 차례로 입장한다
		th.start();//46번 호출됨 - 지연발생함 - 클라이언트가 접속할때까지 기다림...
	}

	// 서버소켓과 클라이언트 소켓을 연결
	@Override//추상메소드
	public void run() { // public int run()안된다고 반환타입 건드리지 말라고
		//서버에 접속해온 클라이언트 스레드 정보를 관리할 벡터 생성하기 
        //벡터는 멀티스레드에서 안전-서버에 동시접속자 수가 여러명이라 벡터 안에는 클라이언트를 관리하는 스레드를 추가해야 한다;
        //스레드는 메세지를 듣고, 들은 내용을 그대로 클라이언트측에 내보낸다(지어내면 안돼)
        //200#토마토#오늘스터디할까? String Tokenizer st =new StringTokenizer("",#);
        //st,nextToken():String-200
        //st,nextToken():String-토마토 닉네임
        //st,nextToken():String-오늘 스터디 할까? 메세지 -프로토콜 설계
		globalList = new Vector<>();//멀티스레드안전해서 ArrayList대신 사용함
		boolean isStop = false;
		try {//네트워크는 항상 장애가 있다. 예외처리 해야한다 예외가 발생할 가능성이 있는 코드를 넣는다
            //Q. run메소드는 언제 호출 되나요?
            //A. Thread인스턴스변수.start(); 요청시

            //Q.왜 이렇게 함?
            //A.여러 Thread가 존재하고 경합이 벌어진다 우선순위를 따져가며 호출

            //Q.반드시 run메소드를재정의 해야 할까요?
			server = new ServerSocket(8839);//서버포트번호 설정하기
			jta_log.append("Server Ready.........\n");//대기 탐 - 멈춤 - wait
			while(!isStop) {//언제 진입?  -> new Socket(서버의 ip.port)
				socket = server.accept();
				jta_log.append("client info:"+socket+"\n");				
				jta_log.append("client info:"+socket.getInetAddress()+"\n");			
				TalkServerThread tst = new TalkServerThread(this);
				tst.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//////////////////////// [[ end of run ]] /////////////////////////

	@Override
	public void actionPerformed(ActionEvent e) {
		//로그를 파일로 저장하기
		
	}
}
/*
 * 채팅서버 구축
 * 클라이언트에서 접속하면 접속해온 정보를 서버측화면에서 볼 수 있다.(JFrame 상속했다=로그를남겼다)
 * 자바는 단일 상속만 가능 -> 인터페이스로 지원한다(다중상속O)-> 다중인터페이스 구현체는 가능하다
 * 스레드를 구현하는 방법에는 1) Thread 상속 2)Runnable 인터페이스 implements하기
 * 현재 TalkServer는 JFrame을 상속받고 있어서 Runnable을 implements했음 (ex.  extends JFrame implements Runnable, ActionListener)
 * class TalkServer 상속 다음에 클래스 두개 못한다구요(ex. class Talksever extends JFrame,Thread{} (X))
 * 상속을 받거나 implements하면 부모클래스나 인터페이스가 정의하고 있는 메소드를 재정의 할 수 있다.
 * (overriding 선언부는 완전 일치해야한다)
 * 인터페이스는 오직 추상메소드만 갖는다-Runnable도 추상메소드 있다
 * 그게 run메소드 이다.
 */