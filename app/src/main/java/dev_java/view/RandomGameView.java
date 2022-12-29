package dev_java.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//이벤트 처리 담당 임플리먼트
public class RandomGameView implements ActionListener{
    int com=0;
    int my =0;
    public void ranCom(){//컴퓨터 난수받기
        com=(int)(Math.random()*10);
    }
    
    public String compare(int user){ //비교하기
        String msg=null;
        //시도할 때 마다 초기화 해야해 -> 지역변수
        if(com>user){
                msg="높여라";
        }else if(com<user){
                msg="낮춰라";
        }else if(com==user){
            msg = "정답";
        }
        return msg;
    }
    //선언부
    JFrame jf= new JFrame(); 
    //남쪽에 붙임 남쪽에 단일행 jtextfield
    JTextField jtf_input= new JTextField(5);//생성자 파라미터 int 1개
    //중앙에 붙임
    JTextArea jta_display = new JTextArea(10, 20);//생성자 파라미터 int 2개
    //한번에 선언하는 방법은 없을까?? -> 배열 써보자 
    //JFrame에 버튼5개를 배치할거야 
    JScrollPane jsp_diplay =new JScrollPane(jta_display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 밑에 속지 바르고 위에 jta얹어쓰기,수평은 나오지마,수직은 필요할 때 나와
    //생성자
public RandomGameView(){
    System.out.println("디폴트 생성자 호출 성공");
    initDisplay();
}

//화면 처리부
public void initDisplay(){
    System.out.println("initDisplay 호출");
    jtf_input.requestFocus();// 깜빡이 요청 api
    jtf_input.addActionListener(this);//엔터 감지할 수 있어
    jta_display.setEditable(false);//안쓸거야 only read만
    //jf= new JFrame();// 느린 인스턴스화
    jf.add("South",jtf_input);//버튼 붙여줘
    jf.add("Center",jsp_diplay);//버튼 붙여줘 사방중 하나 빠지면 센터가 잡아먹는다

    jf.setVisible(true);//화면 띄우기 가로 세로 없네 > 타이틀만보여
    jf.setSize(400, 500);// 크기 초기화
}   


public static void main(String[] args) {
    System.out.println();
 new RandomGameView();   
 //선언부 없이 생성자만 호출 할 수있다. 인스턴스 변수를 재사용할 일이 없다면 괜찮다
 //new RandomGameView()복제본이 생성됨 그러나 서로 다른 객체이다
 //new RandomGameView()마찬가지 타입은 동일 그러나 다른 객체?
}

@Override
public void actionPerformed(ActionEvent e) {
    //엔터의 주소번지를 읽어온다.
    Object obj=e.getSource();
    if(jtf_input==obj){
        System.out.println("사용자가 입력한 값은 "+ jtf_input.getText());
        jta_display.append(jtf_input.getText()+"\n");// 받은 내용은 남아있어야지
        jtf_input.setText("");//사용자 입력받고나서 빈문자열로 초기화
}
}
}