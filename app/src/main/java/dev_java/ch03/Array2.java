package dev_java.ch03;

import java.util.Arrays;

/*
 *배열의 단점
 같은 타입만 담을 수 있다
 중간에 끼워넣기 불가능
 원소의 개수, 과정, 변경 불가 
 */
public class Array2 extends Object {// 상속 aka 확장, 재사용 (오버라이딩경우). 재정의 해서 사용
    int i []=new int[3]; //이른인스턴스화

    int j[]= new int[]{1,2,3};
    int x[]={1,2,3};

    //변수 - 원시배열 - 객체배열 - 자료구조(List,Map) - 쿠키와 세션
    public static void main(String[] args) {
        Array2 a2=new Array2();//인스턴스화
        System.out.println(a2.x.toString());//배열의 다양한 api
        System.out.println(Arrays.toString(a2.i));//배열의 다양한 api 배열 전체 뽑기
        System.out.println(Arrays.toString(a2.j));
        System.out.println(Arrays.toString(a2.x));
        for(int a=0;a<a2.j.length;a++){
            System.out.println(a2.j[a]);

        }
        for(int y:a2.j){//타입 : 배열
            System.out.println(y);

        }
    }//end of main
}