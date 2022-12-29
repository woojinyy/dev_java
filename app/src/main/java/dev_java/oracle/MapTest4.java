package dev_java.oracle;

import java.util.HashMap;
import java.util.Map;

public class MapTest4 {
 public static void main(String[] args) {
    Map<String,Object>rmap =new HashMap<>();
    rmap.put("mem_id", "tomato");
    System.out.println("1:"+rmap);
    rmap = new HashMap<>();//새로운 객체가 생성되었다. 타입은 같지만
    rmap.put("mem_id", "apple");//변수명은 똑같은데 값은 달라
    System.out.println("2:"+rmap);
    rmap = new HashMap<>();
    System.out.println("3:"+rmap);
 }   
}
