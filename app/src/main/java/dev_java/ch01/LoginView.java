package dev_java.ch01;

//java.lang 폴더에 없는 클래스는 모두 import문을 작성해야한다.
import javax.swing.JFrame;

public class LoginView {
    public static void main(String[] args) {
        JFrame jf_login = new JFrame();
        // 로그인창의 가로길이를 담는 변수 선언
        int width = 500;
        // 로그인찬의 세로길이를 담는 변수 선언
        int height = 500;
        // 창의 타이틀바에 문자열
        jf_login.setTitle("로그인창.Ver1.0");
        // 창의 크기를 정해주는 메소드 호출
        jf_login.setSize(width, height);
        MethodExam m3 = new MethodExam();
        // 창을 화면에 활성화 또는 비활성화 불리언(참,거짓)
        jf_login.setVisible(m3.done());
    }
}