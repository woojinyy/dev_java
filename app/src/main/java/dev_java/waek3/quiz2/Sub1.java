package dev_java.waek3.quiz2;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sub1 implements ActionListener{ 
   // Sub1 sub1 =null;
    //선언부 - 전역변수의 위치
    JDialog jdg=new JDialog();
    JButton jbtn=new JButton("저장");
    Main1 main1 = null; //선언만 했다. null의 의미는 결정되지 않았다. 원본을 쓰겠다= 어디서 인스턴스화 했냐 인스턴스화 한곳에 원본이 있다.
  //Main1 main1 = new Main1();//선언,생성하고 생성자도 호출 했다. 복제본이 만들어진다.
    //선언에서 결정되는 건 "타입"만 결정된다 원시형 선언이면 0 double 0.0 boolean false 
    //class(참조형) null 참조형에만 Null PointerException 이있다. 참조형은 부르면 주소번지가 나온다.
    //원시형에서는 Null PointerException 있을 수 없다. 필드와 메소드를 가질 수 없다. 원시형은 부르면 값이 나온다
    //sub1.insert();  sub1이 인스턴스화 되어있어야 한다 NullPointerException 이면 메모리에 아무것도 없다는 뜻이다
    //public Sub1()//다른 생성자
    public Sub1(Main1 main1){//생성자는 전역변수의 초기화를 한다
        System.out.println(main1);
        if(main1==null)System.out.println("main1은 null입니다 객체생성 안 된 상태");
        //언제 ?     Main1이 실행 될 때
        //어디서?   Main1클래스에서
        //왜?        입력을 받았을 때 
        this.main1=main1;//전역변수 초기화 객체 치환 null > main1
        initDisplay();
    }
    public void initDisplay(){
        jdg.add("South",jbtn);//남쪽에 jbtn 붙여줘
        jbtn.addActionListener(this);
        jdg.setTitle("Sub1");
        jdg.setSize(200, 300);
        jdg.setVisible(true);
    }
        int insert(){//예를 들어 1이 넘어오면 성공 0이 넘어오면 실패
            //지역변수이기 때문에 main1 접근이 불가능하다
            return 1;
        }
        //call back method 저장 버튼의 클릭을 JVM이  감지 하고 정해놓은 메소드 호출 한다
        //파라미터인 ActionEvent 객체를 동해서 이벤트가 감지된 버튼을 구분할 수 있다.
        //이 객체는 파라미터에 있으므로 JVM으로 부터 주입이 되는 객체이다.
        //즉, 개발자가 인스턴스화 따로 하지 않고 JVM이 알아서 해준다.
        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();
            //반복문을 탈출할 때는 break문을 사용하고
            //조건문을 탈출할 때는 return을 사용한다
            if (jbtn == obj) {//주소번지가 같다면 클릭감지를 인식한다
                int result = insert();
                if(result==1){
                    JOptionPane.showMessageDialog(jdg,"입력성공");
                    main1.refresh();//actionPerformed 탈출
               // 생성하는 순간 화면 두개 열려 따라서 초기화 해야한다
                    jdg.dispose();
                }else if(result==0){
                    JOptionPane.showMessageDialog(jdg,"입력실패");
                }
                
        }
    }
    }