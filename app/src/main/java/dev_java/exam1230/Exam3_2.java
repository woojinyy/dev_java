package dev_java.exam1230;

public class Exam3_2 {
    public static void main(String[] args) {
try {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    int num1 = sc.nextInt();
    int num2 = sc.nextInt();
    System.out.println("두 수의 나눗셈 결과 : " + num1 / num2);
    
} catch (ArithmeticException e) {
    System.out.println("부적절한 나눗셈을 시도하였습니다");
}       
    }
}
