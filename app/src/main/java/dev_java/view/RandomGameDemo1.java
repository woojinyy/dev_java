package dev_java.view;

    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JScrollPane;
    import javax.swing.JTextArea;
    import javax.swing.JTextField;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    public class RandomGameDemo1 implements ActionListener{
//선언부
     
        JFrame jf= new JFrame(); //이른 인스턴스화
        //남쪽에 붙임 남쪽에 단일행 jtextfield
        JTextField jtf_input= new JTextField(5);//생성자 파라미터 int 1개
        //중앙에 붙임
        JTextArea jta_display = new JTextArea(10, 20);//생성자 파라미터 int 2개
        //한번에 선언하는 방법은 없을까?? -> 배열 써보자 
        JScrollPane jsp_diplay =new JScrollPane(jta_display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 밑에 속지 바르고 위에 jta얹어쓰기,수평은 나오지마,수직은 필요할 때 나와
        //생성자
    public RandomGameDemo1(){
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
    //UI  API를 활용하여 공부를 하면
    //1 초기화를 활용할 수 있게된다
    //2생성자 역할에 대해 알게 된다
    //3사용자 정의 메소드를 많이 만들어 볼 수 있따
    //4 파라미터와 리턴 타입에 대해 확실해 진다
    //5 전역변수와 지역변수를 구분하여 코딩을 전게하게 된다
    //6 클래스를 나누는 조건을 갖게 된다
    //7.이벤트 처리를 사전학습 할 수 있다.
    //8 익명클래스를 활용할 수 있다. 익명함수,arrow function 등 신문법을 공부하는 데 도움이된다
    
    
    public static void main(String[] args) {
        System.out.println();
     RandomGameDemo1 rgd=new RandomGameDemo1();   
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





