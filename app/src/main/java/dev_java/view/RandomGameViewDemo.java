package dev_java.view;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//이벤트 처리 담당 임플리먼트
public class RandomGameViewDemo implements ActionListener {
    // 선언부
    // JFrame jf=null;느린인스턴스화
    JFrame jf = new JFrame(); // 이른 인스턴스화
    JButton jbtn_north = new JButton("북쪽");// 생성자 파라미터가 String
    JButton jbtn_west = new JButton("서쪽");// 생성자 파라미터가 String
    JButton jbtn_south = new JButton("남쪽");// 생성자 파라미터가 String
    JButton jbtn_east = new JButton("동쪽");// 생성자 파라미터가 String
    JButton jbtn_center = new JButton("중앙");// 생성자 파라미터가 String
    // 한번에 선언하는 방법은 없을까?? -> 배열 써보자
    // JFrame에 버튼5개를 배치할거야
    // 생성자

    public RandomGameViewDemo() {
        System.out.println("디폴트 생성자 호출 성공");
        initDisplay();
    }

    // 화면 처리부
    public void initDisplay() {//메서드의 파라미터 개수 리턴값 
        System.out.println("initDisplay 호출");
        jbtn_south.addActionListener(this);
        jbtn_center.addActionListener(this);
        jbtn_west.addActionListener(this);
        // jf= new JFrame();// 느린 인스턴스화
        jf.setVisible(true);// 화면 띄우기 가로 세로 없네 > 타이틀만보여
        jf.setSize(400, 500);// 크기 초기화
        jf.add("North", jbtn_north);// 버튼 창에 붙이기
        jf.add("West", jbtn_west);// 버튼 붙여줘
        jf.add("South", jbtn_south);// 버튼 붙여줘
        // jf.add("East",jbtn_east);//버튼 붙여줘
        jf.add("Center", jbtn_center);// 버튼 붙여줘 사방중 하나 빠지면 센터가 잡아먹는다
    }
    // UI API를 활용하여 공부를 하면
    // 1 초기화를 활용할 수 있게된다
    // 2생성자 역할에 대해 알게 된다
    // 3사용자 정의 메소드를 많이 만들어 볼 수 있따
    // 4 파라미터와 리턴 타입에 대해 확실해 진다
    // 5 전역변수와 지역변수를 구분하여 코딩을 전게하게 된다
    // 6 클래스를 나누는 조건을 갖게 된다
    // 7.이벤트 처리를 사전학습 할 수 있다.
    // 8 익명클래스를 활용할 수 있다. 익명함수,arrow function 등 신문법을 공부하는 데 도움이된다

    public static void main(String[] args) {
        System.out.println();
        new RandomGameView();
        // 선언부 없이 생성자만 호출 할 수있다. 인스턴스 변수를 재사용할 일이 없다면 괜찮다
        // new RandomGameView()복제본이 생성됨 그러나 서로 다른 객체이다
        // new RandomGameView()마찬가지 타입은 동일 그러나 다른 객체?
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 눌린 버튼의 문자열을 읽어온다.
        System.out.println(e.getActionCommand());
        // 눌린 버튼의 주소번지를 가져온다
        System.out.println(e.getSource());
        String label = e.getActionCommand();// 선언부의 남 중 서 가져온다
        if ("중앙".equals(label)) {
            System.out.println("중앙버튼 클릭");
        } else if ("서쪽".equals(label)) {// 처음 조 건 따지면 일 안해도 돼 else if 문이 ㄷ ㅓ 효과적
            System.out.println("서쪽버튼 클릭");
        } else if ("남쪽".equals(label)) {
            System.out.println("남쪽버튼 클릭");
        }
    }
}