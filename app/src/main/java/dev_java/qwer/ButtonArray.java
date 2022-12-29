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
public class ButtonArray implements ActionListener{
    //선언부 
    JFrame jf =new JFrame();// 인스턴스화만 해도 쓸수 있는 setSize(400,300);가로세로크기/// setVisible(true);윈도우창 활성화
    JPanel jp_center = new JPanel();
    JTextArea jta_display= new JTextArea(10,20);
    JScrollPane jsp_display =new JScrollPane(jta_display);// 위에 얹어 쓴다
    JTextField jtf_input = new JTextField();





    JPanel jp_east= new JPanel();
    JButton jbtn_new = new JButton("새게임");
    JButton jbtn_dap = new JButton("정답");
    JButton jbtn_clear = new JButton("지우기");
    JButton jbtn_exit = new JButton("종료");
    //생성자
    public ButtonArray(){
        System.out.println("디폴트 생성자 호출");
        //이벤트 소스와 이벤트 처리를 담당하는 핸들러클래스를 매핑하기
        jtf_input.addActionListener(this);//추상매서드 =callbackmethod 구현체메서드로 생각한다
        initDisplay();
        jbtn_clear.addActionListener(this);
        jbtn_dap.addActionListener(this);
        jbtn_new.addActionListener(this);
        jbtn_exit.addActionListener(this);
    }

    //화면 그리기
    public void initDisplay(){
        jp_center.setLayout(new BorderLayout());
        jp_center.add("Center",jsp_display);
        jp_center.add("South",jtf_input);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//런 x버튼 누르면 꺼짐
        jbtn_new.setBackground(new Color(0, 204, 0));
        jbtn_new.setForeground(new Color(0,204,0));
        jbtn_dap.setBackground(new Color(0,204,0));
        jbtn_dap.setForeground(new Color(0,204,0));
        jp_east.setLayout(new GridLayout(4,1,2,2));
        jp_east.add(jbtn_new);
        jp_east.add(jbtn_dap);
        jp_east.add(jbtn_clear);
        jp_east.add(jbtn_exit);
        jp_center.setBackground(Color.pink);
        jf.add("Center",jp_center);
        jf.add("East",jp_east);
        jf.setSize(400,300);
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        
        new ButtonArray();
    }

    @Override//callbackmethod
    public void actionPerformed(ActionEvent e) {
        //e.getSource는 이벤트 감지되는 구성요소(JTextField)의 주소번지를 반환함
        Object obj =e.getSource();
        //새게임??
if(jbtn_new==obj)/*주소번지비교*/{
jta_display.append("새게임을 시작합니다\n");


}
        //정답 확인
        else if(jbtn_dap==obj){
            jta_display.append("정답은 xxx");
        }//화면 지워
        else if(jbtn_clear==obj){
            jta_display.setText("");
            //그만하기
        }else if(jbtn_exit==obj){
            jta_display.setText("");
                //jf.dispose();//창 하나씩 닫고 싶을 때
               // System.exit(status:0);//한번에 다 닫을 때
        }
        //JTextField에서 엔터 감지
       else if(jtf_input==obj){
            //사용자가 텍스트 필드에 입력한 문자열을 
            String input = jtf_input.getText();
            jta_display.append(input+"\n");
            jtf_input.setText("");
        
        }
        //이벤트처리 3단계
        //1 어떤 Listener인지 찾기
        //2 핸들러클래스 연결
        
    }
}
