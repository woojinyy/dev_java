package dev_java.network3;

import javax.swing.JFrame;

public class BananaServer extends JFrame {//파라미터값
    //생성자
    
        public  BananaServer(String title){
        initDisplay(title);
    }
    public void  initDisplay(String title){
        this.setTitle(title);
        this.setSize(400, 300);
        this.setVisible(true);
}
//this는 클래스 쪼개기 즉 화면과 로직의 분리 또는 하나의 클래스를 여러개의 클래스로
//나누어 처리할 때만 필요하다
//메인
public static void main(String[] args) {
    //생성자 호출하기  생성자 메소드오버로딩  파라미터에 오브젝트 타입일 때 어렵다
    //new BananaServer();
    //생성자 파라미터에는 this외 다르나 타입을 사용 가능함
    new BananaServer("생성자파라미터로 제목을 결정함- 초기화");
}
BananaServer(){
    //super(title);//super는 상위프레임 this는 바나나 서버
    //this는 BananaServer
    //this(title): 자기자신을 호출하는 것이므로 에러
    
}//제목 초기화하는 두번째 생성자 정의
}
//바나나톡은 생성자에서 initDisplay호출



/*관전포인트
* initDisplay를 mainmethod에서
* 생성자에서 호출하는 것이 가능하다
*Q. 둘의 차이는?
*/