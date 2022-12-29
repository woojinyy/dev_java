package dev_java.waek3;

import java.util.Arrays;

public class ArrayCopy1 {
    void deepCopy1(){   
        int [] org ={1,2,3};//1,2,3
    int [] copy=org.clone();//1,2,3
    copy[2]=5;//1,2,5    1,2,5
    for (int e:org){
        System.out.println(e);
    }
    for (int e:copy){
        System.out.println(e);
    }
}
    void deepCopy2(){   
        int [] org ={1,2,3,4,5};//1,2,3
        int [] copy=Arrays.copyOf(org,2);
        copy[2]=5;//
    for (int e:org){
        System.out.println(e);
    }
    for (int e:copy){
        System.out.println(e);
    }
    
    }
    public static void main(String[] args) {
        ArrayCopy1 ac1= new ArrayCopy1();
        ac1.deepCopy1();
      /*/  int [] org ={1,2,3};//1,2,3
        int [] copy=org;//1,2,3
        copy[2]=5;//1,2,5    1,2,5
        for (int e:org){
            System.out.println(e);
        }
        for (int e:copy){
            System.out.println(e);
        }
    }*/
}
}
/*
 * 배열복사 자바스크립트 노드js에서 배열은 일급? 컨벤션이 달라 범용성이 높다
 * 복사 컨셉
 * 얕은 복사 & 깊은 복사
 * 
 * 얕은복사 : 복사된 배열이 원본배열인덱스값이 변경될 때 같이 변경된다
 * 객체의 주소값만 복사하는 것
 * 깊은 복사 : .clone();  복사본 인덱스가 변경되어도  원본 인덱스값이 변경되지 않는다.
 *객체의 실제값을 새로운 객체로 복사하는 것 각자도생 
 * 
 * 일부 복사 : Arrays.copyOf
 */
