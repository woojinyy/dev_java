package dev_java.weak4.Exam1221;

import java.util.Vector;

public class A1 {//변수 이름은 똑같아도 주소번지가 다르다
    int ival= 1;

    public static void main(String[] args) {
        Vector<Integer> v =new Vector<>();
        A1 a1=new A1();
        a1.ival=10;
        System.out.println(a1);//주소값
        v.add(a1.ival);
        System.out.println(v);//10
        a1=null;//객체 초기화 하면 다음 라인 넘어갈 때 캔디데이트 상태가 된다
        a1=new A1();
        a1.ival=20;
        v.add(a1.ival);
        //insert here
        //Q. 14번라인에서  ival10을 다시 출력하고 싶다 어쾀???
        System.out.println(v.get(0));//10
        System.out.println(v);//10,20
        System.out.println(a1.ival);//20
       
    }
}
