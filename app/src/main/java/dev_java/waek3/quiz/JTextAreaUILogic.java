package dev_java.waek3.quiz;
import javax.swing.JTextArea;
public class JTextAreaUILogic {
    //메모리 StackOverFlow발생
    //인스턴스화 위치 중요하다-서버뒤진다

    //여기서 직접 인스턴스화 하면 복제본이 만들어진다 -망 복제본이 출력된다
JTextAreaUI jtaUI=null;
    public JTextAreaUILogic(JTextAreaUI jTextAreaUI) {
        //생성자 안에서 JTextAreaUI의 JTextArea원본과 전역변수를 초기화 해줘야 한다. -어렵다
    this.jtaUI=jTextAreaUI;
    }

    public void account(String input) {
        
        //Q. JTextAreaUI클래스에 정의된 주소번지 어떻게 사용할까?
        jtaUI.jta.append("UILogic "+ input+"\n");
        
    }

}
