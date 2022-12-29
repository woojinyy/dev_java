package dev_java.network3;

import javax.swing.JFrame;

public class KiwiServer extends JFrame implements Runnable{
//선언부


//생성자
public KiwiServer(){
    System.out.println("KiwiServer디폴트생성자 호출");
    
}
public void initDisplay(){
    this.setTitle("키위톡");
    this.setSize(400, 300);
    this.setVisible(true);
}

//메인
public static void main(String[] args) {
    KiwiServer ks = new KiwiServer();
    ks.initDisplay();
    Thread th  = new Thread(ks);
    th.start();
}
@Override
public void run() {
    System.out.println("run호출 성공");
    //경합이 벌어지는 
    //지연(대기) 필요한 
    //일반 메소드로 처리할 때와 차이는
    //1. 보장 100%실행 (순서에맞게)  <-> 일반메소드는 어플리케이션 종료되면 보장 못받는다.
    //2.개별적으로 동작을 할 수 있다.
    
}
}

/*키위는 메인메소드에서 initDisplay를 호출 */

/*
 * 상속
 * implements
 */