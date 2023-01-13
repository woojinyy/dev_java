package dev_java.weak7;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class KiwiPanel1 extends JPanel implements ActionListener {
    ////////////////////////////////////////////
    // 이른 인스턴스화??? 게으른 인스턴스화???//
    ////////////////////////////////////////////
    // 생성자는 필요한가?? 생성자가 필요하다면 왜??//
    // 파라미터는 필요한가?? 왜? 어떤타입이???/////
    /// 어느시점에??? //////
    /////////////////////////////////////////////
    
    JButton jbtn1 = new JButton("배경화면");
    JButton jbtn2 = new JButton("글꼴");
    JButton jbtn3 = new JButton("글자크기");
    static Font f = null;// 반드시 static으로 해야 하는 이유는 패널1번에서 결정된 설정값이
                         // 패널2,3에도 적용 되어야 하기 때문 =공유
    static boolean isSize = false;

    public KiwiPanel1() {// 디폴트 생성자
        /////////////////////////////////////////////////////////
        // initDisplay(); 여기에 메소드 있고 없고 차이 알고있니???///
        /////////////////////////////////////////////////////////
        initDisplay(); // A. 여기 있어야 해
    }

    public void initDisplay() {
        jbtn3.addActionListener(this);
        this.setLayout(null);
        jbtn1.setBounds(140, 80, 100, 30);
        jbtn2.setBounds(140, 150, 100, 30);
        jbtn3.setBounds(140, 220, 100, 30);
        this.add(jbtn1);
        this.add(jbtn2);
        this.add(jbtn3);

    }

    public static void main(String[] args) {
        // kPanel1.initDisplay(); 여기에 있는게 맞아???????????
        // 이벤트 처리
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == jbtn3) {
            if (!isSize) {
                f = new Font("", Font.BOLD, 18);
                System.out.println("첫번째 버튼 클릭");
                jbtn1.setFont(f);
                jbtn2.setFont(f);
                jbtn3.setFont(f);
                isSize = true;
            } else {
                f = new Font("", Font.BOLD, 12);
                System.out.println("두번째 버튼 클릭");
                jbtn1.setFont(f);
                jbtn2.setFont(f);
                jbtn3.setFont(f);
                isSize = false;
            }
        }
    }
}
/*
 * Q. 생성자 안에서initDisplay()를 호출하는 것과 그렇지 않은것의 차이는?
 * A.
 * 재사용성을 위해 인스턴스화 하고
 * 
 * 위치의 문제이며 화면 정의서의 요구 사항에 따라서 다른 선택이 되어야 한다
 * 
 */
