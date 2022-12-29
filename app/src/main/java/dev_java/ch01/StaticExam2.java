package dev_java.ch01;

public class StaticExam2 {

    public static void main(String[] args) {
        StaticExam1 staticExam1 = new StaticExam1();
        StaticExam1 staticExam2 = new StaticExam1();
        StaticExam1 staticExam3 = new StaticExam1();

        staticExam1.methodA();
        staticExam2.i = 5;//전역변수를 재정의 할 수 있다.
        staticExam3.i=3;
        System.out.println(staticExam1.i);//타입은 같으나 객체가 다르다
        System.out.println(staticExam2.i);
        System.out.println(staticExam3.i);
    }
}