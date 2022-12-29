package dev_java.ch02;

import java.util.Random;
import java.util.Scanner;

public class Random1 {
    public static void main(String[] args) {
        //랜덤하게 수를 뽑는 메소드를 제공하는 클래스 선언 및 생성
    Random r = new Random();
    //new다음에 오는 이름의 객체가 로딩 -> 생성자 호출도 발생
   //Scanner calss를 사용해 입력장치로 입력된 정보를 가져올 수 있다 = 듣기
   //생성자의 파라미터에 입력장치에 대한 코드가 필요
   //System <- 내가 사용하는 컴퓨터의 장치 
   //뒤에 변수 in 을 붙여 입력장치를 나타낸다
   //사용자로부터 입력받는 장치를 생성자 파라미터에 적는다
    Scanner scanner=new Scanner(System.in);
//nextint method는 Scanner class가 소유주이다
    int com = r.nextInt(10);//0~9 중 난수하나를 임의선택
    System.out.println("채번한 숫자는="+com);
    int my=0;//내가 입력할 수 초기화
    boolean isOK=true;
    while(isOK){//true를 줬으면 무한루프다
        //순서도에 맞게 작성은 while이 좀 더 편하다
      
          //사용자에게 입력받아야 하는 유요한 값의 범위를 출력
        System.out.println("0부터 9사이의 정수를 입력해");
        //nextint() : int 
        my=scanner.nextInt();
        //컴퓨터가 고른 값과 사용자가 입력한 값이 같니?
        System.out.println("사용자가 입력한 값"+my);
        if (com== my){//변수가 값이 같은지 비교
            //원시형 변수 이다(= 직접 접근방식)
            System.out.println("ㅊㅋ");
            scanner.close();//다 사용한 scanner의 주소번지는 닫는다
            //위변조 방지
            break;
        }else if(com>my){
            System.out.println("up");//난수가 입력한 값보다 크면 > up
        }else if (com<my){
            System.out.println("down");// 난수가 입력한 값보다 작으면 >down 
        }else if(my==100){
            System.exit(0);//연결고리 끊어 빠져나갈래5
        }
    
    }
  



} 
}

