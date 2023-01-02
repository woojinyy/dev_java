package dev_java.exam1230;

import java.net.ServerSocket;
import java.net.Socket;
//단일 상속만 되니까 인터페이스 지원함
//인터페이스를 통해 스레드 구현방법
public class ChatServer implements Runnable {
    public static void main(String[] args) {
        System.out.println("main 시작");
        ChatServer cs= new ChatServer();
        Thread th = new Thread(cs);
        th.start();
        System.out.println("main 끝");
    }

    @Override
    public void run() {
        System.out.println("run  호출 성공");
        int port= 3000;
        ServerSocket server =null;
        try {
            server = new ServerSocket(port);
            //chatclient에서 new Socket("서버ip",3000)
            System.out.println("서버소켓 생성완료-클라이언트 소켓 접속 기다리는 중");
            while(true){
                //언제 진행됨? new Socket("서버ip");
                Socket client= server.accept();
                System.out.println("클라이언트 정보"+client.getInetAddress());//접속한 클라이언트 정보 출력
                //대기상태 풀림
                //금융권에서 사용하는 =보안 강화 - 직렬화
                //말하기   ObjectOutputStream ->writeObjec();네트워크 전송 일어남 패킷단위
                //듣기      ObjectInpitStream  ->readObject();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            

        }

    }
}
