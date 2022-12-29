package dev_java.ch01;

public class Method2 {
//반환형이 void일때와 반환형이 있을 때 출력하는 방법이 다르다

    double m1(double d) {
       return d;// 변수라능
        //return 3.5;// 고정값을 반환해서 무슨짓을 해도 3.5가 나온다

    }///// end of m1

    public static void main(String[] args) {
        Method2 method2 = new Method2();
        //method 내부에 출력하는 문장이 없는 경우
        //외부 method에서 결정된 값을 출력하려면  반환형이 필요하다
        double result = method2.m1(1.5);//1.5
        System.out.println(result);//3.5
      //  method2.m1(3.1);

    }///// end of main
}
