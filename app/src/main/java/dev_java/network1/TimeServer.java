package dev_java.network1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
//서버를 기동하고 클라이언트가 접속해 오기를 기다린다. ->기다리면 스레드
import java.util.Calendar;
public class TimeServer extends Thread {
    //선언부
    //객체 직렬화가 가능하고 듣기와 쓰기가 가능한 I/O관련 클래스 선언
    ObjectOutputStream oos=null;//소켓이 있어야만 객체생성 가능 (timeserver가)말하기할때 사용
    ObjectInputStream ois=null;//소켓이 있어야만 객체생성 가능 (client가)듣기를 할 때 사용
    Socket client = null;//전역변수 
    //동시에 여러사람이 접속을 시도함
    //run 메소드 재정의 스레드에서 해야 할 일을 처리
    //반드시 선언부와 일치해야한다. =부모가 가진 메소드=스레드
    //TimeServer is a Thread 관계가 성립하니까 상속처리 가능
    TimeServer(){}
    //아래 생성자가 필요한 이유는 서버 소켓의 접속해 온 클라이언트 소켓을 
    //run메소드에서 사용해야 하니까 전역변수로 치환해아한다.
    TimeServer(Socket client){
        this.client = client;
    }
    @Override
    public void run(){
        //스레드 구현 메소드에서 서버 소켓에 접속해온 client소켓을 가지고 
        //말하기와 듣기에 필요한 oos와 ois객체를 생성 해야한다.
        //I/O도 지연과 데드락상태에 빠질 수 있으므로 반드시 예외처리 해야한다.
        try {
            oos = new ObjectOutputStream(client.getOutputStream());
            ois = new ObjectInputStream(client.getInputStream());
            while(true){
                oos.writeObject("현재시간\n"+getTimeMessage());//
                try {
                    sleep(1000);//1초동안 멈췄다 동작
                } catch (InterruptedException ie) {
                }
            }
        } catch (Exception e) {
        }
    }//end of run
    //메인메소드
    public static void main(String[] args) {
        //동시에 여러사람이 접속
        //포트번호 필요-> 서버소켓 생성시 파라미터로 포트번호 필요함
        int port =8839;
        ServerSocket server = null;
        Socket client=null; //소켓은 서버소켓에 접속한 클라이언트소켓(주소번지)이다 여러명이 들어온다
        try {//예외처리 
            server=new ServerSocket(port);
        } catch (IOException ie) {//연결이 안됐다면 catch
        System.out.println("Can't bind port"+port);
        ie.printStackTrace();//에러메세지를 라인번호와 함께 출력 -디버깅할때 써먹는다
        try {
            server.close();
        } catch (Exception e) {
            System.exit(0);//서버 강제종료
        }
        }///////////end of try..catch
        System.out.println("TimeServer started successfully");
        while(true){//손님이 올 때까지 기다린다
            try {
                //클라이언트가 접속해 오기를 기다리다가 접속(=new Socket(ip주소,포트넘버)실행)하면 
                //아래 메소드가서버소켓에 클라이언트 소켓정보를 취득하게된다
                client=server.accept();
                System.out.println(client.getInetAddress());//클라이언트의 네트워크 정보 확인
                System.out.println("New Client connected");
                //스레드의 개입이 필요하다 1초동안 sleep(1000)(=1초동안멈추라는뜻)메소드를 호출 하고 
                //현재 시분초정보를 출력해야한다
                // -> 스레드 동작시킴 (=스레드 추상메소드 run을 호출)
                //주의 : run을 직접 호출하는 게 아니라 start()메소드를 호출 하면 JVM이 순서를 따져서 시킴(신호에 맞춰 동작 call by value)
            TimeServer ts = new TimeServer(client);//run에서 client 사용하고싶어서 파라미터 넘긴다
            ts.start();//run메소드 직접호출 말고 start메소드로 호출한다
            System.out.println("New TimeServer Thread started");
            } catch (Exception e) {
            }
        }
    }
    public String getTimeMessage(){//시간정보 Calendal
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        return (hour<10?"0"+hour:""+hour)+":"+(min<10?"0"+min:+min)+":"+(sec<10?"0"+sec:""+sec);
    }

    
}
