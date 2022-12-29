package dev_java.oracle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest1 {
    Map<String, Object> rMap = new HashMap<>();// rMap.size()=0; 초기화 전
    // 초기화

    public void setMap() {
        rMap.put("deptno", 10);// int값
        rMap.put("dname", "인사부");
        rMap.put("loc", "서울");
    }

    public static void main(String[] args) {
        MapTest1 mt1 = new MapTest1();
        System.out.println(mt1.rMap.size());// 0
        mt1.setMap();//
        System.out.println(mt1.rMap.size());// 3
        Set<String> set = mt1.rMap.keySet();
        Object obj[] = set.toArray();// set 인터페이스가 제공하는 메소드 중에서 toArray()
        for (int i = 0; i < obj.length; i++) {// 배열.length는 배열의 원소 수
            String key = (String) obj[i];// 배열에서 꺼낸 값은 key값 (컬럼명)
            System.out.println("key :  " + key);
        }

        // 키 가져오기 keyset
        // Set<String> set = mt1.rMap.keySet();
        // 키 출력
        System.out.println("====================================");
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {// 자료구조안에 값이 있는지 체크해서 있으면 true를 반환하고 ,없으면 false반환
            String key = iter.next();
            // String value=(String)mt1.rMap.get(key);//리턴이 object String으로 형전환
            Object value = mt1.rMap.get(key);// Object로 받으면//ClassCastException Integer를 String으로 못바꿈

            System.out.println(key + ":" + value);
        }
    }
}
