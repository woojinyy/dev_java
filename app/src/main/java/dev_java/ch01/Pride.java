package dev_java.ch01;

public class Pride {

    static String carName = "2023년형 프라이드";
    String carColor = "흰색";
    int wheelNum = 4;

    // 에러에는 두가지가 있다
    // 1 문법에러 2런타임 에러(Exception)
    public static void main(String[] args) {

        System.out.println(carName);
        Pride myCar = new Pride();// myCar를 인스턴스 변수라고 한다.
        System.out.println(myCar);
        myCar.carColor = "보라색";
        myCar = null;// 주소번지가 가리키는 객체가 사라졌다BUT 타입은 있다
        System.out.println(myCar);
       // myCar.carColor = "보라색"; // null point exception
        myCar = new Pride();//새로운 주소번지를 갖는다 어디에? 객체에 
        System.out.println(myCar==myCar);
        //
        // myCar.carColor = "검정색";
        System.out.println(myCar.carColor);// 전역변수호출할 때만 인스턴스화를 통해 호출 가능

    }
}
