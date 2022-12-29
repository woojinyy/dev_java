package dev_java.ch01;

import java.util.Scanner;

public class StaticExam7 {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);//(컴퓨터. 입력장치)
    System.out.println("0부터 9사이의 숫자를 입력하세요");
    String user = scanner.nextLine();//호출 : 메소드 이름앞에 . 을 붙이고 그앞에 스캐너 클라스의 변수명을 붙여줘야한다
    System.out.println("사용자가 입력한 숫자는" +user +"입니다");
    System.out.println(user+1);
}    
}
