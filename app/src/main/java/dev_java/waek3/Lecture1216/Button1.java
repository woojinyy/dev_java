package dev_java.waek3.Lecture1216;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Button1 extends JFrame{
    //선언부
    String jbtn_label[] = { "입력", "수정", "삭제" };
    JButton[] jbts=new JButton[3];
    JButton jbtn_ins = new JButton(jbtn_label[0]);
    JButton jbtn_upd = new JButton(jbtn_label[1]);
    JButton jbtn_del = new JButton(jbtn_label[2]);
    JPanel jp_north = new JPanel();
    //생성자
    public Button1() {
        initDisplay();
    }
    //화면그리기
    public void initDisplay(){
        System.out.println(jbts[0]);
        System.out.println(jbts[1]);
        System.out.println(jbts[2]);
        for(int i=0;i<jbts.length;i++){
        jbts[i]= new JButton(jbtn_label[i]);
        System.out.println(jbts[i]);
        }
        jp_north.add(jbtn_ins);
        jp_north.add(jbtn_upd);
        jp_north.add(jbtn_del);
        //버튼 세개를 객체 배열로 바꿔서 표현하시오
        this.add("North",jp_north);
        this.setSize(500,400);
        this.setVisible(true);
    }

//메인메소드
    public static void main(String[] args) {
        new Button1();
    }
    
}
