package dev_java.waek3;

public class Main {
    int i = 1;// 전역변수
    boolean isOk[]= new boolean[3];//[false,false,false]

    public static void main(String[] args) {
        // Q. Sub 전역변수 호출 어떻게?
        Sub s = new Sub();
        System.out.println(s.j);
//Q. Sub의 method 호출 어떻게??
        s.title();
//객체주입 
    }

}
