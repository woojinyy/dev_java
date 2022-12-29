package dev_java.qwer;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputFilter.Status;

public class ButtonArray2 implements ActionListener {//배열로 바꿀거야
    // 선언부
    AccountSample action = new AccountSample(this);//파라미터 있는 생성자 호출
    JFrame jf = new JFrame();// 인스턴스화만 해도 쓸수 있는 setSize(400,300);가로세로크기/// setVisible(true);윈도우창 활성화
    JPanel jp_center = new JPanel();
    JTextArea jta_display = new JTextArea(10, 20);
    JScrollPane jsp_display = new JScrollPane(jta_display);// 위에 얹어 쓴다
    JTextField jtf_input = new JTextField();
    JPanel jp_east = new JPanel();
    JButton jbtns[] = new JButton[4];
    String jbtns_label[] = {"새게임","정답","지우기","종료"};//버튼안에는 

    // 생성자
    public ButtonArray2() {
        System.out.println("디폴트 생성자 호출");
        // 이벤트 소스와 이벤트 처리를 담당하는 핸들러클래스를 매핑하기
        jtf_input.addActionListener(this);// 추상매서드 =callbackmethod 구현체메서드로 생각한다
        initDisplay();
      
    
    }

    // 화면 그리기
    public void initDisplay() {
        System.out.println("화면그리기 호출");
       
        jp_center.setLayout(new BorderLayout());
        jp_center.add("Center", jsp_display);
        jp_center.add("South", jtf_input);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 런 x버튼 누르면 꺼짐
       /*/ jbtns[0].setBackground(new Color(0, 204, 0));
        jbtns[0].setForeground(new Color(0, 204, 0));
        jbtns[1].setBackground(new Color(0, 204, 0));
        jbtns[1].setForeground(new Color(0, 204, 0));
        선언이 먼저와야해서 for문안에 있는 인스턴스화 뒤에 넣어야 맞다
        배열을 사용할 수도 없어서 위 표기처럼 하나하나 노가다 해야한다*/
        jp_east.setLayout(new GridLayout(4, 1, 2, 2));
        for(int i =0;i<jbtns.length;i++){
            jbtns[i]=new JButton(jbtns_label[i]);
            jbtns[i].addActionListener(this);
            jp_east.add(jbtns[i]);
        }
        jp_center.setBackground(Color.pink);
        jf.add("Center", jp_center);
        jf.add("East", jp_east);
        jf.setSize(400, 300);
        jf.setVisible(true);
    }

    public static void main(String[] args) {

        new ButtonArray2();
    }

    @Override // callbackmethod
    public void actionPerformed(ActionEvent e) {
        // e.getSource는 이벤트 감지되는 구성요소(JTextField)의 주소번지를 반환함
        Object obj = e.getSource();
        // 새게임??
        if (jbtns[0] == obj)/* 주소번지비교 */ {
            jta_display.append("새게임을 시작합니다\n");
           
        }
        // 정답 확인
        else if (jbtns[1] == obj) {
            jta_display.append("정답은 xxx");
        } // 화면 지워
        else if (jbtns[2] == obj) {
            jta_display.setText("");
            // 그만하기
        } else if (jbtns[3] == obj) {
            jta_display.setText("");
             //jf.dispose();//창 하나씩 닫고 싶을 때
            System.exit(0);//한번에 다 닫을 때
        }
        // JTextField에서 엔터 감지
        else if (jtf_input == obj) {
            // 사용자가 텍스트 필드에 입력한 문자열을
            String input = jtf_input.getText();
            //jta_display.append(input + "\n");
            action.account2();
            jtf_input.setText("");

        }
        // 이벤트처리 3단계
        // 1 어떤 Listener인지 찾기
        // 2 핸들러클래스 연결
    }
}