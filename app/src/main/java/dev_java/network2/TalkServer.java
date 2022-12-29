package dev_java.network2;

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
//자바는 단일상속만 가능하다
//자바는 단일상속의 단점을 보완하기 위해 인터페이스는 다중으로 처리가능하다(구현체클래스)
//선언과 생성 분리
public class TalkServer extends JFrame implements Runnable,ActionListener  {//다중상속은 안된다 Runnable을 써야 다중 된다
    //선언부
    //클라이언트쪽에서 new Socket하면 그 소켓정보를 받아서 쓰레드로 넘김
    TalkServerThread 		tst 		= null;
    //동시에 다중인원 접속 List - Vector<>(); 멀티스레드 안전 속도 느림
	List<TalkServerThread> 	globalList 	= null;
	ServerSocket 			server 		= null;
	Socket 					socket 		= null;
	JTextArea 				jta_log = new JTextArea(10,30);
	JScrollPane 			jsp_log = new JScrollPane(jta_log
    ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JButton jbtn_log = new JButton("로그저장");

    //생성자
    public TalkServer(){
        //initDisplay();//시점문제 - 스케줄링 해줘야해 
    
    }
    //화면그리기
    public void initDisplay(){
		jbtn_log.addActionListener(this);
		this.add("North",jbtn_log);
		this.add("Center",jsp_log);
		this.setSize(500, 400);
		this.setVisible(true);
	}
    //메인
    public static void main(String[] args) {//스레드를 쓰면 지연이 발생해 화면이 먼저 호출하고 서버기동해야함
        TalkServer ts=new TalkServer();
        ts.initDisplay();
        Thread th =new Thread(ts);// 파라미터로 ts넣어줘야 협업한다
        th.start();//55번 호출한다 -지연 발생O 클라이언트가 접속 할 때까지 가디림
    }
    @Override
    public void run() {
        //서버에 접속해온 클라이언트 스레드 정보를 관리할 벡터 생성하기 
		globalList = new Vector<>();//멀티스레드 안전해서 arraylist대신사용함
		boolean isStop = false;
		try {
			server = new ServerSocket(8839);//서버 포트번호 설정
			jta_log.append("Server Ready.........\n");//손님올 때까지 대기 wait 
			while(!isStop) {
				socket = server.accept();
				jta_log.append("client info:"+socket+"\n");				
				jta_log.append("client info:"+socket.getInetAddress()+"\n");				
				TalkServerThread tst = new TalkServerThread(this);
				tst.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }////////////////////////////////end of run//////////////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {
        //로그를 파일로 저장하기 
    }
}

