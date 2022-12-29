package dev_java.ch01;

public class Method1 {
    //파라미터 자리는 1.비워두거나 2.원시형을 쓰거나 3. 참조형도 올 수 있다.
    //파라미터 자리는 호출하는 곳에서 결정된다
    //Q. 파라미터 자리에 변수는 언제 초기화 될까요?
    //A. method가 호출될 때 결정된다
    //Q method 호출은 어디에서하지?
    //A main method 안에서 해야 호출된다
    //method parameter자리는 오직 선언만 가능함, 초기화는 안된다
    //어쾀??
    
    void m(int i/*파라미터 자리 int i=5 (X)*/){//파라미터 자리에는 사용자가 입력한 값이 담긴다
      //  i=5;
     // i=i+7;
        System.out.println(i+3);//5
    }///end of m
    double m1(double d){
        return 3.4;

    }/////end of m1
    public static void main(String[] args) {
        //소유주 class를 인스턴스화 해야한다 클래스 안에 정의된 메소드만 호출 가능하다
        Method1 method1 = new Method1();
        //자바에서는 같은 이름의 메소드를 중복선언 할 수 있다.
        //파라미터의 갯수가 다르거나 또는 타입이 다르면 인정 method over loading
        method1.m(3);

    }/////end of main
}
