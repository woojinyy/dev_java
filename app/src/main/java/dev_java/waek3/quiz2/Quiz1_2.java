package dev_java.waek3.quiz2;

import java.util.Scanner;

public class Quiz1_2 {// 사용자 정의 메소드를 만들어서 사용해보자
    //1. 리턴타입을 결정해야한다 -> 결정 방법 Q. main method에서 면적 출력할거야?? Q. 면적구하기메소드에서 면적 출력할거야??
    //                                                              A. double 면적구하기메소드                    A. void 면적구하기메소드 
    //2. 파라미터의 개수와 타입도 선택할 수 있어야 한다.
    
    //선언부
    double area;
    static double area2;  // 전역변수는 초기화 생략 가능하다 JVM이 해주니까
    final double PI = 3.14;

    double 면적구하기메소드(int i1,int i2){//자바에서는 같은 이름의 메소드를 중복선언 할 수 있다
        //단, 파라미터의 개수가 다르거나 ,타입이 달라야 한다. -method over loading
        
        return 0.0;//자동형전환 되기 때문에 int값 넣어도 된다 double > int
        //강제형변환 (받아주는쪽)
    }
    public static void main(String[] args) {
        Quiz1_2 q1= new Quiz1_2();
        int r1,r2 = 0;
       
        Scanner s = new Scanner(System.in);
        System.out.print("첫번째 반지름 입력하세요.");
        String user1 = s.nextLine();
        System.out.println("사용자가 입력한 첫번째 반지름 :" + user1);
        System.out.print("두번째 반지름을 입력하세요");
        String user2 = s.nextLine();
        System.out.println("사용자가 입력한 첫번째 반지름 :" + user2);
   
        int i1 = Integer.parseInt(user1);
        int i2 = Integer.parseInt(user2);
       q1.면적구하기메소드(i1,i2);
        System.out.println("첫번째 반지름 원의 넓이는" + q1.area + "입니다.");
        System.out.println("두번째 반지름 원의 넓이는" + Quiz1_2.area2 + "입니다.");// 스테틱 붙어있으셔  -> 공유한다, 복제본이 없다
    }
}
