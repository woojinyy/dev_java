package dev_java.ch01;

import org.checkerframework.checker.interning.qual.EqualsMethod;

public class String2 {
    public static void main(String[] args) {
        String s1="안녕";
        String s2="안녕";
        //주소번지가 가리키는 값을 비교하려면 equals라는 메소드
        System.out.println( s1.equals(s2));
        System.out.println( s1==s2);
        String s3= new String("안녕");
        String s4= new String("안녕");
        System.out.println( s3.equals(s4));
        System.out.println( s3==s4);
        System.out.println( s1.equals(s4));
        System.out.println( s1==s4);
        //s1과 s2의 주소번지는 같습니까? Y 0r N
        //s3 과 s4의 주소번지는 같습니까? Y or N
        //그 이유는??
    }
}
