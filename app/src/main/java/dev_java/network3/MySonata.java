package dev_java.network3;

public class MySonata extends MyCar {// 추상클래스가 구현체클래스 되려면 부모가 갖고있는 재정의 해야한다 =인터페이스랑 똑같다

    MySonata() {
        System.out.println("MySonata() 디폴트 호출 성공");
        
    }

    @Override
    public void display() { // 아빠가 갖고있는 메소드 -> 추상메소드 왜? 구체화 자동차 > 소나타
        System.out.println("나는 23년형 소나타입니다.");

    }

    public static void main(String[] args) {
        MySonata ms = new MySonata();// 디폴트생성자 생략O
    }
}// Q. run하면 아빠 생성자도 호출된다? 아니다?
 // A. 힌트. method ovrriding 원형을 고치면 안된다 = 선언문이 똑같다
 // 기준= 아빠
 // 아빠가 무슨메소드를갖고있는지 알아야해
 // 부모의 생성자가 먼저 메모리에 올라온다 overriding의 기준이 된다.
