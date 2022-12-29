package dev_java.ch03;

public class FinalVariable {
    static void methodA(){
        int i =8;
        i=5;//재정의 된다
        final double PIE=3.14;//final 붙이면 재정의 안된다 무적이다최최최최최최최종
        //PIE=5.45;
        System.out.println(PIE);
    }
    public static void main(String[] args) {
        FinalVariable.methodA();
     //  System.out.println(PIE);//안된다
        
    }
}
