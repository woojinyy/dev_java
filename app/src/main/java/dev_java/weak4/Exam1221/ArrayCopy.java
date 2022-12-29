package dev_java.weak4.Exam1221;

import java.util.Arrays;

public class ArrayCopy {
    String fruit[]={"사과","딸기","바나나"};
    String fruit2[];
    public ArrayCopy(){
    }
    public ArrayCopy(String[] args){//파라미터가 있는
        fruit2=fruit; //2에 원본을 복사한다 얕은 복사
        fruit2[1]="키위";//복사본이 바뀌면 원본도 바뀐다
        System.out.println(Arrays.toString(fruit));
        System.out.println(Arrays.toString(fruit2));
        
    }
    public static void main(String[] args) {
        new ArrayCopy();
        
    }
}
