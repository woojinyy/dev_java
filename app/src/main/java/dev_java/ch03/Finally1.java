package dev_java.ch03;
//java 예외처리
//java finally사용법
public class Finally1 {
    public static void main(String[] args) {
        int i = 10;
        int j=0;
        //만약 j가 0이면?터진다 > try catch
        try {
            System.out.println(i/j);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }finally{
            System.out.println("finally는 무조건 실행");
        }
       



    }
}
