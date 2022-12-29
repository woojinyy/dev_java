package dev_java.Exam1208;

import java.util.Scanner;//ctrl+shift+f 개꿀

public class Q1 {
     public void count() {
          System.out.println("count 호출");// 로그에 출력할 값 확인
          Scanner sc = new Scanner(System.in);
          boolean isOk = false;

          while (!isOk) {// 상수싫어요 변수좋아요
               System.out.print("문자열을 입력 : ");
               String str = sc.nextLine();
               // if(str.equals("exit")){널타임 에러난다
               if ("exit".equals(str)) {// 상수와 비교해야 한다
                    break;// while문 탈출
               } else {
                    System.out.println(str.length() + "글자입니다."); // length() 길이를 반환
               }
          } // end of while
          System.out.println("종료");
          sc.close();
     }// end of count

     public static void main(String[] args) {
          Q1 cnt = new Q1(); // static 안에서 non-static호출하려면 인스화 필요
          cnt.count();

     }
}
