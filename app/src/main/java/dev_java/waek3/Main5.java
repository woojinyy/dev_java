package dev_java.waek3;
class A{
    int i =1;
    Main5 main5= null;

    public A(Main5 main5){
        System.out.println("호출");
       this. main5=main5; //초기화 
    }
    public A() {
    }
    void methodB(){
        main5.methodA();
    }
}

public class Main5 {
    A a =new A(this);//파라미터 this없으면 null point exception 에러
    
    void methodA(){
        System.out.println("Main5 methodA()호출");
    }
    public static void main(String[] args) {
        Main5 main5 = new Main5();
        main5.a.methodB();
    }
}
