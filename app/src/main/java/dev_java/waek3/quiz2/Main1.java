package dev_java.waek3.quiz2;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main1 {
    //새창을 띄워보자 
   Sub1 sub1= new Sub1(this);//JVM : this =Main1에서 정의하고있는 메소드를 Sub1에서 호출해보자 
   //입력 >저장 >새로고침> 부모 메소드 호출 > this를 넘기자
    JFrame jf= new JFrame();
   
    public Main1(){//디폴트 생성자 안에서 화면을 그리는 initDisplay가 호출되고 있다.
        //Q. 화면이 두 개 열린다?? 
        initDisplay(); 
        //메소드의존성
    }
    public void initDisplay(){
       
        jf.setTitle("Main1");
        jf.setSize(400, 500);
        jf.setVisible(true);
        System.out.println("initDisplay호출");
    }
    public void refresh(){
        System.out.println("refresh()-호출");
        JOptionPane.showMessageDialog(jf, "새로고침 처리 되었습니다.");
    }
    public static void main(String[] args) {
        //Main1 main1=new Main1();// Main1 호출
        new Main1(); //인스턴스화 원본이다 
       //new Main1().initDisplay();// non-static method를 static영역에서 호출이 불가능
       
        
    }
}
/*
 * 디폴트 생성자는 파라미터가 생략이 가능하다
 * 파라미터가 있는 생성자는 생략이 불가능하다
 * 파라미터가 있는 생성자가 하나라도 있으면
 * 디폴트생성자의 파라미터는 생략불가능하다
 * 인스턴스화 할 때 생성부의 이름으로 객체가 생성된다
 * 이때 파라미터자리에 인자를 추가할 수 있다. 여러개의 생성자를 선언할 수 있다.
 * 메소드 오버로딩이 적용된다 같은이름의 생성자 생성 O 단, 파라미터의 개수,타입이 달라야 한다
 */