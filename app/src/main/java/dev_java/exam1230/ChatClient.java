package dev_java.exam1230;

import java.net.InetAddress;
import java.net.Socket;

public class ChatClient {
    public void client(){
        int port = 3000;
        String serverIP= "192.168.10.78";
             //java.net, java.io인터넷 회선 장애 대비 try-catch
            //  IO생성시  소켓을 통해 인스턴스화를 하게되어 의존관계 있다.
            //이런 패키지는 반드시 예외처리 할 것(Thread 인터셉트를 당할 수 있다.제어권을 뺏긴다)
            //Object마다  Lockflag값이 있어서 스레드가 점유하면 잠긴다.-> 다른 Thread는 사용불가
            //DeadLock상태에 빠질 수 있다.(안에서 잠금으로 다른 Thread가 사용불가 상태_)
            //한정된 자원을 여러 사람이 이용하기위해 제공되는 클래스가 Thread
            //Thread.sleep(), join, yield, intercept ... 
            try {
            System.out.println(InetAddress.getLocalHost().getHostAddress());
            Socket socket= new Socket(serverIP, port);
        } catch (Exception e) {
            e.printStackTrace();//에러 메시지에 대한 histroy 를 기억하고 라인번호와 함께 
            //이력을 출력해줌
            //디버깅시에 꼭 필요
        }
    }
    public static void main(String[] args) {
        ChatClient cc= new ChatClient();
        cc.client();
    }
}
