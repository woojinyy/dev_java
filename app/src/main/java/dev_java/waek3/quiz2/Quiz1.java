package dev_java.waek3.quiz2;

import java.util.Scanner;

public class Quiz1 {//반지름 두개 받아서 원의 면적 구해라
    //변수 세개 필요 파이는 상수로 하자  면적 
    public static void main(String[] args) {
        int r1 =0;//반지름 1
        int r2=0;//반지름 2
        double area=0.0;//면적
        double area2=0.0;//면적
        final double PI =3.14;//재정의가 불가능하다 파이널은 무적이다
        //접근제한자 private > friendly > protected > public 
        //                     나만     같은 패키지     상속관계        모두
        //static 변수앞에, 메소드앞에, 클래스 앞에
        //final 변수앞에 , 메소드앞에(overriding 불가), 클래스 앞에(상속불가=자손을 못가짐)
        //첫번째 반지름 입력 받기
        Scanner s =new Scanner(System.in);//인스턴스화-> 메모리에 로딩이 된다 메소드나 변수를 호출할 수 있다(=사용 가능)
        //new 다음에 오는 클래스가 생성된다 이 때 생성자가 호출된다 (마치 메소드 처럼)
        System.out.print("첫번째 반지름 입력하세요.");
        String user1=s.nextLine();//netxLine 반환값은(리턴타입) String  키보드 값을 읽어 오세요(=호출)  
        System.out.println("사용자가 입력한 첫번째 반지름 :"+user1); 
        //누구나 언제 어디서나 똑같다 =static 정적이다 파라미터로 String을 받아서 int값을 반환한다
        //반환값이 void는 재사용이 불가능 하다 
        //스트링을 인트로 형 전환해야해 자동형이 있고 강제형전환이 있다 
        //JVM에 integerparseint가 있다 
        System.out.print("두번째 반지름을 입력하세요");
        String user2=s.nextLine();
        System.out.println("사용자가 입력한 첫번째 반지름 :"+user2); 
        //소유주or인스턴스변수.  > Integer.parseInt()
        //static int parseint(String s)
        int i1=Integer.parseInt(user1);//첫번째 반지름을 원시형 int 로 저장한다
        int i2=Integer.parseInt(user2);//두번째 반지름을 원시형 int 로 저장한다
        area=i1*i1*PI;
        area2=i2*i2*PI;
        System.out.println("첫번째 반지름 원의 넓이는"+area+"입니다.");
        System.out.println("두번째 반지름 원의 넓이는"+area2+"입니다.");
    }
}
