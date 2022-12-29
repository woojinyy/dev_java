package dev_java.ch03;

import java.util.Arrays;

public class Array4 {
    public static void main(String[] args) {
        int i[] = { 1, 2, 3 };
        int j[];
        j = i;
        System.out.println(Arrays.toString(j));
        System.out.println(j.length);//방어 코드 배열의 사이즈에 맞게
        int k[];
        k = new int[3]; //{ 1, 2, 3 };
        j = k;// Q. k 왜 에러?????????:?????????
        // A. 둘다 초기화 안했는데 안한애들끼리 치환하면 에러 아닐까?

        System.out.println(Arrays.toString(j));
        System.out.println(j.length);//배열의 사이즈
        //length()문자열의 길이 ex)hello = 5
      //  String s1 = "ㅎㅇ";
       // String s2 = s1;
    }
}
