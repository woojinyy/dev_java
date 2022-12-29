package dev_java.ch01;
//java.lang패키지 이외 클래스는 import를 추가해야함
//안하면 컴파일에러 class 생성이 안 됨
//class 의 구성요소 2가지 - 함수형 프로그래밍 처리방법 =람다식= 일급함수 일급객체(프론트엔드)
//1.명사형 field= variable =변수
//2.동사형 method =function=함수
//field+method= class defined 
//class 를 인스턴스화 하면 메모리에 로딩이 된다=램에 상주한다
//클래스를 인스턴스화 하는 이유는 변수와 method 호출하기 위해서
//인스턴스화 . method명(파라미터);
//전역변수도 호출 할 수 있다.
//인스턴스화 . 전역변수(원시형O 참조형O);
//static 공유한다 instance화를 못하니까 하나다
//500명이 들어와서 결제하면 어쾀?
//원시형은 클래스가 아니니까 변수와 method를 가질 수 없다. 원시형은 값이 나오니까
import java.util.Scanner;
public class ScannerExam1 {
    
    public static void main(String[] args) {
        System.out.println("0부터 9사이싀 숫자를 입력해");
        //java.util.Scanner scanner = new ScannerExam1(System.in); 생성부의 파라미터 자리는 시스템의 입력장치정보
        //[생성자, method]의 {파라미터 개수와 타입}은 반드시 지켜라
        //import 문 추가 안하면 인스턴스화 해서 사용해야함 개귀찮음
        //편하게 import 문 추가해라
        Scanner scanner = new Scanner(System.in);
     String user= scanner.nextLine();// 인스턴스변수=소유주
     scanner.close();//닫아야 한다.
    
      //wrapper 
            int i_user = Integer.parseInt(user);//Integer 타입
            System.out.println(user+1);
            System.out.println(i_user+1);
    }
}
