package dev_java.waek3.quiz2;

public class Rectangle {

    public static void main(String[] args) {
        int x= 2 ;//x가로y세로
        int y= 3 ;
        int area= 0 ;
        System.out.println(area = x * y);
        
    }
}
/*메인메소드 안에서 처리하기에서
 * 문제제기
 * 원의 면적도 구하고 싶다면?
 * 삼각형은?
 * 그러면서 
 * 사각형면적도 구해야해 -> 재사용성 이식성 활용해라
 * 오버라이딩 actionperformed 
 * 자바에서는 같은이름의 메소드를 선언할 수 있다.
 * 메소드 오버 라이딩 + 메소드 오버로딩
 * 메소드 이름이 같을 때만 따진다 다르면 메소드 오버라이딩 = 오버로딩
 * 오버라이딩의 경우 서로 상속관계 있거나  인터페이스의 
 * 단 파라미터의 개수 혹은 타입이 달라야한다
 * @ 파라미터 못건들여  메소드 이름이 같아야해
 * 추상체의 구현체일 때 만
 */