package dev_java.weak4.Exam1221;

import java.util.Arrays;

public class ArrayCopy11 {//couy1에 있는 전역변수를 호출하고싶어

    public static void main(String[] args) {
        ArrayCopy ac=new ArrayCopy();
        System.out.println(ac.fruit);
        System.out.println(Arrays.toString(ac.fruit2));//null 초기화 안했어
        System.out.println(Arrays.toString(ac.fruit));//null 초기화 했어
        ac.fruit2=new String[]{"바나나","사과","귤"};//재정의->복사가 아니야
        System.out.println(ac.fruit2[1]);//null point exception
        
    }
}
