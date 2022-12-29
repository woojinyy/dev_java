package dev_java.oracle;

public class Pride extends Object{//모든 클래스는 Object 상속받고있다
    //Object 클래스에는 toString ()정의되어 있다.
    //모든클래스는 toString을 오버라이딩 할 수 있다.

    @Override
    public String toString(){
return "pride자동차입니다.";
    }

    public static void main(String[] args) {
    Pride myCar= new Pride();
        System.out.println(myCar);    //주소번지
        System.out.println(myCar.toString());  //주소번지  
    }
}
