package dev_java.weak4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//java.lang 패키지가 아닌것은 모두 import사용해야함

import javax.swing.JButton;
import javax.swing.JFrame;

class Button1 extends JFrame {// 상속,추상클래스 중심, 인터페이스 중심 코딩 전개
    // 선언부
    Button1Event bevent = new Button1Event(this);// 파라미터가 왜 this????
    // 버튼 두개 붙이기
    JButton jbtn_ins = null;// 선언만 생성자 호출 안 됨=게으른 인스턴스화 선언의 방법 위치 생각해봐
    JButton jbtn_upd = new JButton("수정");// 선언 및 생성 동시에 생성자 호출까지 발생
    // =이른 인스턴스화

    // 생성자
    Button1() {
        System.out.println("Button1 디폴트 생성자 호출!!" + jbtn_ins);
        System.out.println("initDisplay 호출 후" + (jbtn_ins == null));
        jbtn_ins = new JButton("입력");// 생성만
        System.out.println("입력버튼 생성 후" + (jbtn_ins == null));
        initDisplay();// new Button1이 호출 되면 자동으로 생성자 호출
        // 생성자 안에서 인스턴스화 버튼 객체를 생성하면 뭐가 다르지?
        // Q.시점에 따라 뭐가 발생한다?
        // A.null point exction 발생한다
    }

    // 화면 처리부
    public void initDisplay() {
        jbtn_upd.addActionListener(bevent);//this를 쓸 수 없다  action implement안했고 actionperformed 정의 안했어
        
        System.out.println("initDisplay 호출 성공!!");
        JButton jbtn_del = new JButton("삭제");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if (jbtn_ins != null) { // null이 아닐 때만 버튼 추가 =>선택적으로 처리 실행기회에 대한 선택
            this.add("North", jbtn_ins);
        }
        this.add("South", jbtn_upd);
        this.add("East", jbtn_del);
        this.setSize(400, 300);
        this.setVisible(true);

    }
}

class Button1Event implements ActionListener {
    Button1 button1 = null;

    public Button1Event(Button1 button1) {
        this.button1= button1;           // this가 없으면? null point exception 에러  치환을 해줘야 한다
        //Button1 button1= new Button1();  인스턴스화 하면 복사본이다.
    }

    @Override
    // ActionListener의 구현체 클래스이다 = 이벤트 핸들러 클래스이다.
    // 인터페이스는 추상메소드만 갖는다 그 이름이actionPerformed
    public void actionPerformed(ActionEvent e) {// actionPerformed라는 추상메소드
        Object obj = e.getSource();
        // 수정버튼 눌렀니?
        if (obj == button1.jbtn_ins) {
            System.out.println("수정버튼 클릭");
        }
    }
}

public class Button1Main {
    public static void main(String[] args) {
        Button1 b1 = new Button1();//

    }
}
