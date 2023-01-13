package dev_java.weak7;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;

public class KiwiApp extends JFrame implements ActionListener {
    // 선언
    String imgPath = "D:\\vscod_java\\dev_java\\app\\src\\main\\java\\dev_java\\images\\dvd\\";
    Image img[] = null;
    ImageIcon imgs[] = new ImageIcon[3];
    String imgNames[] = { "admin2.png", "delay.png", "broken2.png" };// for문돌릴거라 배열로 놓자
    JPanel jp_south = new JPanel();
    JPanel jp_center = new JPanel();// south 위에 센터 추가
    JButton jbtn1 = new JButton();
    JButton jbtn2 = new JButton();
    JButton jbtn3 = new JButton();
    JButton imgButton[] = { jbtn1, jbtn2, jbtn3 };// 버튼 담을거니까 버튼보다 뒤에놓자
    Container container = this.getContentPane();// Jframe에서만 객체주입받는다 JPanel에서는 불가 생성자 파라미터를 넘겨서 사용해야한다
    // 일괄처리, 정적 static
    KiwiPanel1 kPanel1 = null;
    KiwiPanel2 kP2 = null;
    KiwiPanel3 kP3 = null;// Q.언제 화면갱신합니까?? A.버튼 눌렀을 때 화면 갱신된다 오버라이딩한 if문에서

    public KiwiApp() {

    }

    // 화면그리기
    public void initDisplay() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jbtn1.addActionListener(this);
        jbtn2.addActionListener(this);
        jbtn3.addActionListener(this);
        jp_center.setBackground(Color.DARK_GRAY);
        jp_south.setLayout(new GridLayout(1, 3));// n등분 해주는 레이아웃
        // jp_south.add(jbtn1);
        // jp_south.add(jbtn2);
        // jp_south.add(jbtn3);
        for (int i = 0; i < imgs.length; i++) {
            imgs[i] = new ImageIcon(imgPath + imgNames[i]);
            imgButton[i].setIcon(imgs[i]);
            // 버튼 테두리 선 페인팅 없애기
            imgButton[i].setBorderPainted(false);
            imgButton[i].setFocusPainted(false);
            imgButton[i].setContentAreaFilled(false);
            jp_south.add(imgButton[i]);// 이미지 붙이는
        }
        this.add("South", jp_south);
        this.add("Center", jp_center);
        this.setSize(400, 500);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        KiwiApp kApp = new KiwiApp();
        kApp.initDisplay();
    }

    @Override
    public void actionPerformed(ActionEvent e) {// 추상메서드 오버라이딩
        Object obj = e.getSource();// 첫번째 버튼 눌렀는지 물어본다
        if (obj == jbtn1) {// 화면은 여기서 띄운다 그럼 게으른인스턴스화 해야해? 이른인스턴스화해야해?
            System.out.println("첫번째");
            if (kP2 != null) {
                container.remove(kP2.jta);
                container.remove(kP2.jtf);
                container.remove(kP2);
            }
            if (kP3 != null) {
                container.remove(kP3.jsp_dept);
                container.remove(kP3);
            }
            kPanel1 = new KiwiPanel1();// 생성자 안에서 initDisplay()호출
            this.add("Center", kPanel1);
            container.revalidate();

        } else if (obj == jbtn2) {// 두번째 버튼 눌렀는지 물어본다
            System.out.println("두번째");
            if (kPanel1 != null) {
                container.remove(kPanel1.jbtn1);
                container.remove(kPanel1.jbtn2);
                container.remove(kPanel1.jbtn3);
                container.remove(kPanel1);
            }
            if (kP3 != null) {
                container.remove(kP3.jsp_dept);
                container.remove(kP2);
                kP2 = new KiwiPanel2(this);
                this.add("Center", kP2);
                container.revalidate();
            } else if (obj == jbtn3) {// 세번째 버튼 눌렀는지 물어본다
                System.out.println("세번째");
                if (kPanel1 != null) {
                    container.remove(kPanel1.jbtn1);
                    container.remove(kPanel1.jbtn2);
                    container.remove(kPanel1.jbtn3);
                    container.remove(kP2);
                }
                if (kP2 != null) {
                    container.remove(kP2.jta);
                    container.remove(kP2.jtf);
                    container.remove(kP2);
                }
                kP3 = new KiwiPanel3(this);
                this.add("Center", kP3);
                container.revalidate();
            }
        }
    }
}

/*
 * 이른인스턴스화 했을 떄
 * 
 * 
 * 게으른 인스턴스화 했을 때
 */