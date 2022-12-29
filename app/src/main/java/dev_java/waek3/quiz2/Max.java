package dev_java.waek3.quiz2;

import java.util.Scanner;

public class Max {
    //선언부
   
public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("첫번째 숫자를 입력 하세요");
    String user1 = s.nextLine();
    System.out.print("두번째 숫자를 입력 하세요");
    String user2 = s.nextLine();
   
    int i1 = Integer.parseInt(user1);
    int i2 = Integer.parseInt(user2);
    if(i1>i2) {
         System.out.println("큰 수"+i1);
    } else if(i1<i2){
    System.out.println("큰 수" +i2);
    }
}
}
