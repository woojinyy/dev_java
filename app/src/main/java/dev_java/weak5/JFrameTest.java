package dev_java.weak5;

import javax.swing.JFrame;

public class JFrameTest extends JFrame{
    JFrameTest(){
        //super("제목");
        this("제목2");//this()  생성자 = 나자신 -> 12번 호출
this.setSize(400,300);
this.setVisible(true);
try {
    Thread.sleep(5000);
} catch (InterruptedException ie) {
}
    }
    JFrameTest(String title){
        this.setTitle(title);
    }
    public static void main(String[] args) {
        new JFrameTest();
    }
    
}
