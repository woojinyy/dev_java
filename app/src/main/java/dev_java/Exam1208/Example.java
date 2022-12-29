package dev_java.Exam1208;

public class Example {
    public static void main(String[] args) {
        String s1 = new String ("안녕");// new는객체 생성  타입은 같지만 서로다른 객체
        String s2 = new String ("안녕");//s2배열
        String s3 = "안녕";//s3 문자열 //원시형타입
        String s4 = "안녕";//s4문자열
        if(s1==s2) System.out.println("1주소번지 같니?");// == 주소값을 비교하는 연산자
        //  boolean 참or거짓이 온다
        if(s1.equals(s2))System.out.println("2주소번지 같니?");//객체끼리 비교하는 메서드
        //파라미터에는 오브젝트
        //숫자 비교는 ==  
        //String.equals(오브젝트)  클래스의 주소번지 
        if(s3==s4)System.out.println("3주소번지 같니?");
        if(s3.equals(s4))System.out.println("4주소번지 같니?");
        if(s4.equals("안녕"))System.out.println("5주소번지 같니?");
        if("안녕".equals(s4))System.out.println("6주소값이 같니?");
    }
}/* 재사용성
 */
