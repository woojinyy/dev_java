package dev_java.weak7;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class KiwiPanel2 extends JPanel implements ActionListener {
    JTextArea jta = new JTextArea("");//속지붙이기
    JTextField jtf = new JTextField("");
    JPanel jp_south = new JPanel();
    JPanel jp_center = new JPanel();
    //키위앱을 통해서 패널에 접근해야해
    KiwiApp kiwiApp= null;
    public KiwiPanel2() {
initDisplay();
    }
    public KiwiPanel2(KiwiApp kiwiApp){//파라미터로 받아오기
            this();//17번 본인 디폴트 생성자 호출
            this.kiwiApp=kiwiApp;//초기화
    }
public void changeFontSize(){
    jta.setFont(KiwiPanel1.f);//jta폰트 설정
    jtf.setFont(KiwiPanel1.f);//jtf폰트 설정
}
    public void initDisplay() {
        if(KiwiPanel1.isSize){
            changeFontSize();
        }
        this.setLayout(new BorderLayout());
        this.add("South", jtf);
        this.add("Center", jta);
        

    }
public static void main(String[] args) {
    new KiwiPanel2();
    
}
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
