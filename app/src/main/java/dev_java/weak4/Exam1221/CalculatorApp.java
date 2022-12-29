package dev_java.weak4.Exam1221;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.util.Vector;
import java.awt.Font;

public class CalculatorApp extends JFrame implements ActionListener {// if ,for, 이벤트 처리,연산자 연습해라
    // 선언
    Vector<String> vsetnum = new Vector<>();

    JTextField jtf_display = new JTextField(10);
    JPanel jp_center = new JPanel();
    JButton jbtn_clear = new JButton("C");
    JButton jbtn_equal = new JButton("=");
    JButton jbtn_one = new JButton("1");
    JButton jbtn_two = new JButton("2");
    JButton jbtn_three = new JButton("3");
    JButton jbtn_four = new JButton("4");
    JButton jbtn_five = new JButton("5");
    JButton jbtn_six = new JButton("6");
    JButton jbtn_seven = new JButton("7");
    JButton jbtn_eight = new JButton("8");
    JButton jbtn_nine = new JButton("9");
    JButton jbtn_zero = new JButton("0");
    JButton jbtn_plus = new JButton("+");
    JButton jbtn_minus = new JButton("-");
    JButton jbtn_mult = new JButton("*");
    JButton jbtn_div = new JButton("/");
    JButton jbtn_1=new JButton("1");
    Font f = new Font("Paryrus", Font.BOLD, 40);

    //숫자 입력
    public void Num(String passNum) {
        String sNum = null;
        for (int i = 0; i < vsetnum.size(); i++) {
            sNum = vsetnum.get(i);
        }

    }

    // 연산
    public void calculate(String y) {
        int sum = 0;
        if ("+".equals(y)) {
            for (int i = 0; i < vsetnum.size(); i++) {
                sum += Integer.parseInt(vsetnum.get(i));
            }
        } else if ("-".equals(y)) {
            for (int i = 0; i < vsetnum.size(); i++) {
                sum -= Integer.parseInt(vsetnum.get(i));
            }
        } else if ("*".equals(y)) {
            for (int i = 0; i < vsetnum.size(); i++) {
                sum *= Integer.parseInt(vsetnum.get(i));
            }
        }
        else if ("/".equals(y)) {
            for (int i = 0; i < vsetnum.size(); i++) {
            sum = Integer.parseInt(vsetnum.get(i));
            }
        }
    }

    // 생성
    public CalculatorApp() {
        initDisplay();
    }

    // 화면처리
    public void initDisplay() {
        jbtn_one.setFont(f);
        jbtn_two.setFont(f);
        jbtn_one.setForeground(Color.RED);

        jp_center.setBackground(Color.CYAN);
        jp_center.setLayout(new GridLayout(2, 10, 2, 2));
        jp_center.add(jbtn_plus);
        jp_center.add(jbtn_minus);
        jp_center.add(jbtn_mult);
        jp_center.add(jbtn_div);
        jp_center.add(jbtn_equal);
        jp_center.add(jbtn_clear);
        jp_center.add(jbtn_one);
        jp_center.add(jbtn_two);
        jp_center.add(jbtn_three);
        jp_center.add(jbtn_four);
        jp_center.add(jbtn_five);
        jp_center.add(jbtn_six);
        jp_center.add(jbtn_seven);
        jp_center.add(jbtn_eight);
        jp_center.add(jbtn_nine);
        jp_center.add(jbtn_zero);
        jbtn_one.addActionListener(this);
        jbtn_two.addActionListener(this);
        jbtn_three.addActionListener(this);
        jbtn_four.addActionListener(this);
        jbtn_five.addActionListener(this);
        jbtn_six.addActionListener(this);
        jbtn_seven.addActionListener(this);
        jbtn_eight.addActionListener(this);
        jbtn_nine.addActionListener(this);
        jbtn_zero.addActionListener(this);
        jtf_display.setEditable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add("North", jtf_display);
        this.add("Center", jp_center);
        this.setTitle("동무가 만들어준 계산기");
        this.setSize(500, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new CalculatorApp();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = new Object();
        
        if(obj==jbtn_one){
            vsetnum.add("1");
        }else if(obj==jbtn_two){
            vsetnum.add("2");
        }else if(obj==jbtn_three){
            vsetnum.add("3");
        }else if(obj==jbtn_four){
            vsetnum.add("4");
        }else if(obj==jbtn_five){
            vsetnum.add("5");
        }else if(obj==jbtn_six){
            vsetnum.add("6");
        }else if(obj==jbtn_seven){
            vsetnum.add("7");
        }else if(obj==jbtn_eight){
            vsetnum.add("8");
        }else if(obj==jbtn_nine){
            vsetnum.add("9");
        }else if(obj==jbtn_zero){
            vsetnum.add("0");
        }
    }
}
