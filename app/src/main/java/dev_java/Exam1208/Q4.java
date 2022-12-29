package dev_java.Exam1208;

public class Q4 {
    public static void main(String[] args) {
        int a;
        if (5 < 4) {
            a = 50;
        } else {
            a = 40;
        }
        System.out.println(a); // 결과 = 40

        // 삼항연산자
        int b = (5 > 4) ? 50 : 40;// 조건문 ? 참 : 거짓 ;
        System.out.println(b); // 결과 = 40
    }
}
