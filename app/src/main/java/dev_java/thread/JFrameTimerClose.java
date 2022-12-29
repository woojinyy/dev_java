package dev_java.thread;

import javax.swing.JFrame;

public class JFrameTimerClose extends JFrame{
    public JFrameTimerClose(){
        super("JFrame테스트-5초후 창 닫기");
        this.setSize(500, 500);
        this.setVisible(true);
        //대기
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
        ie.printStackTrace();//디버깅ㅇ할 때 필요하다 외워라
        }
        setVisible(false);//5초후 창 사라짐
    }
    public static void main(String[] args) {
        new JFrameTimerClose();//생성자 호출
    }
}
