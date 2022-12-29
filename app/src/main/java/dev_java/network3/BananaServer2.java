package dev_java.network3;

import javax.swing.JFrame;

public class BananaServer2 extends JFrame {//상속관계에서 생성자 호출 순서
	// 생성자
	BananaServer2() {
		initDisplay();
	}

	BananaServer2(String title) {
		super(title); //super = JFrame -> this.setTitle() 호출
		initDisplay();
		// 아래서 this는 BananaServer를 가리키는 것임
		// this(title);자기자신을 호출하는 것이므로 에러임
	}

	public void initDisplay() {
		this.setSize(400, 300);
		this.setVisible(true);
	}

	// this는 클래스 쪼개기 즉 화면과 로직의 분리 또는 하나의 클래스를 여러개의 클래스로
	// 나누어(분업) 처리할 때만 필요함-this(), this("안녕") - 실무에서 사용할 일이 없다
	public static void main(String[] args) {
	//Q. 파라미터 생성자로 title추가했을 때 이 정보를 initDisplay에
    //setTitle에 사용하고싶다 방법은?
        //A. 
		new BananaServer2("생성자 파라미터로 제목을 결정함-초기화");
	}
}
/*
 * 관전 포인트
 * initDisplay를 메인메소드에서 호출하는 것과 생성자 안에서 호출하는 것이 가능하다.
 * 그렇다면 둘의 차이는 있나? 혹은 없나?
 * 작업지시서
 * 키위톡은 메인메소드에서 initDisplay호출함
 * 바나나톡은 생성자에서 initDisplay호출함
 */
// 바나나톡은 생성자에서 initDisplay호출

/*
 * 관전포인트
 * initDisplay를 mainmethod에서
 * 생성자에서 호출하는 것이 가능하다
 * Q. 둘의 차이는?
 */