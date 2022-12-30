package dev_java.weak6;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Y {
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Vector<Integer> vlist = new Vector<>();
        Integer[] is= new Integer[3];
        is[0] =1;
        is[1] =2;
        is[2] =3;
        //list.copyinto();//인터페이스 list 안에는 copyinto메소드가 정의 안 돼있다.
        vlist.copyInto(args);
    }
}
