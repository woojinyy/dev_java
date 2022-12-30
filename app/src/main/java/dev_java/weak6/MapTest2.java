package dev_java.weak6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest2 {
    public static void main(String[] args) {
        List<Map<String,Integer>> list = new ArrayList<>();
        Map<String,Integer> map1=new HashMap<>();
        map1.put("one", 1);
        map1.put("two", 2);
        map1.put("three", (int)3.0);//타입 맞춰라
        Map<String,Double> map2 =new HashMap<>();
        //이상한 애다 그냥 외우자 
        map2.put("2one", new Double(1));//타입 맞춰라//왜?? 참조형이잖아 (= 주소번지)
        map2.put("2two", (double)1.0);//타입 맞춰라//왜?? 참조형이잖아 (= 주소번지)
        map2.put("2three", 3.0);//얘는 왜 ??
        int i =2;
        double d=i;  //원시형은 부르면 값이 나온다
        //////////////////////////////////////////////////////////////////////////////////
        Map<String, Object> map3 =new HashMap<>();//Object는 슈퍼 슈퍼마켓 무적이다
        //얘는 왜 받아줘???????????????
        map3.put("3one", 1);
        map3.put("3two",1.0);
        map3.put("3three", 3.0);
    }
}
