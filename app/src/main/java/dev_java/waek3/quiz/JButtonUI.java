package dev_java.waek3.quiz;
import javax.swing.JFrame;
import javax.swing.JButton;

public class JButtonUI {
    JFrame jf =new JFrame();
    JButton jbtn_south = new JButton("전송");
    JButtonUIEvent jbtn=new JButtonUIEvent(this);
     // 생성자
     public JButtonUI() {
        initDisplay();

    }
    // 화면처리부
    public void initDisplay() {
        // 이벤트 소스와 이벤트 핸들러 매핑시 this를 쓸 수 있는건
        // 오직 내안에 actionPerformed가 구현되어 있을 때 뿐
        jbtn_south.addActionListener(jbtn);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// X버튼 클릭시 정상종료
        jf.add("South", jbtn_south);
        jf.setSize(500, 600);
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        new JButtonUI();
    }
}
