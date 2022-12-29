package dev_java.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest5 {
    public static void main(String[] args) {
        List<Map<String,Object>>list=new ArrayList<>();
        Map<String, Object> rmap = new HashMap<>();
        rmap.put("mem_id", "tomato");
       // System.out.println("1:" + rmap);
        list.add(rmap);
      //  rmap = new HashMap<>();// 새로운 객체가 생성되었다. 타입은 같지만
      rmap = new HashMap<>();  
      rmap.put("mem_id", "apple");// 변수명은 똑같은데 값은 달라
      list.add(1,rmap);
        //  System.out.println("2:" + rmap);
        //tomato 출력하고 싶어 
        System.out.println(list.get(0));
       // rmap.put("mem_id", "tomato");
       // System.out.println("2:" + rmap);
        rmap = new HashMap<>();
       // System.out.println("3:" + rmap);
    }
}
