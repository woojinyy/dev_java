package dev_java.network1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JLabel;

public class TimeClient extends Thread {
    Socket socket = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    //JLabel jlb_timer = new  JLabel();
    JLabel jlb_timer= null;

    public TimeClient() {
    }

    public TimeClient(JLabel jlb_timer) {
        this.jlb_timer=jlb_timer;
    }

    @Override
    public void run() {
        // 서버로 부터 읽어온 시간 정보를 담기
        String timeMsg = null;
        try {// 아래가 실행되자마자 TimeServer의 ServerSocket이 accept()호출하여
             // 클라이언트 소켓 정보를 서버가 취득함
            socket = new Socket("192.168.10.78", 8839);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            while(true){
                try {//순서,경합,지속 Thread 예외처리는 필요하다
                    while((timeMsg=(String)ois.readObject())!=null){
                            System.out.println(timeMsg);
                            jlb_timer.setText(timeMsg);
                    }
                } 
                catch (Exception e) {
                }
            }//end of try
        } catch (IOException ie) {
            System.out.println("You can't access to TimeServer");
        }finally{
            try {
                oos.close();
                ois.close();
                socket.close();
            } catch (Exception e) {
            }
        }

    }

    // 메인
    public static void main(String[] args) {
        Thread th = new TimeClient();// 선언부와 생성부가 다르다 다형성 구현이 가능
        // 자바에서는 new다음에 오는 이름으로 객체가 생성된다(생성부의 이름)
        th.start();// run 호출
    }
}
/*
 * TimeServer에서 제공하는 현재 시간정보를 읽어오는 클래스 구현
 * 그런데 스레드를 상속받은 이유는 1초마다 읽어와야 하기 때문이다.
 * 따라서 sleep(1000)을 호출해야 한다 즉 나는 스레드이어야 한다. 스레드 이면서 클래스 슬립메소드는 스레드가 제공하기 때문
 * 1초마다 계속 읽어와야 하니까 무한루프 돌린다. 종료시 꺼진다
 * 
 */