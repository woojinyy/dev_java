package dev_java.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapTest2 {
    List<Map<String, Object>> list = new ArrayList<>();
    Map<String, Object> rMap = new HashMap<>();// rMap.size()=0; 초기화 전
    // 초기화
    // 원본rMap에 넣고싶어

    public void setMap() {
        rMap.put("deptno", 10);
        rMap.put("dname", "인사부");
        rMap.put("loc", "서울");
        list.add(rMap);// 첫번째 방에 add
        rMap = new HashMap<>();// Map<String, Object> rMap=new HashMap<>();타입은 붙이지마
        rMap.put("deptno", 20);
        rMap.put("dname", "개발부");
        rMap.put("loc", "부산");
        list.add(rMap);// 두번째 방에 add
        rMap = new HashMap<>();
        rMap.put("deptno", 30);
        rMap.put("dname", "기술부");
        rMap.put("loc", "제주");
        list.add(rMap);// 세번째 방에 add
    }

    public void mapPrint() {// 출력하는 메소드 만들어 보자
        // 각 로우 안에 key가 세개 있다(컬럼-deptno,dname,loc)
        // Map m1= get(0)에 대한 칼럼 3개, Map m2= get(1)에 대한 칼럼 3개, Map m3=get(2)에 대한 칼럼 3개
        for (int i = 0; i < list.size(); i++) {// 반복해서 처리할 것은 로우값get(0),get(1),get(2) -> List 반복(ArrayList이다(구현체))
            Map<String, Object> m1 = list.get(i);
            // 컬럼의 수를 반복해서 출력해야한다
            Object[] keys = m1.keySet().toArray();// 키값이 들어간다 deotno, dname ,loc
            for (int j = 0; j < keys.length; j++) {
                String key = (String) keys[j];
                System.out.println(m1.get(keys) + " ");

            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MapTest2 mt2 = new MapTest2();
        System.out.println(mt2.rMap.size());// 0
        mt2.setMap();// Map의 size는 세로방향이다 컬럼의 수이다
        System.out.println(mt2.rMap.size());// 3
        Set<String> set = mt2.rMap.keySet();

        // 키 가져오기 keyset
        // 키 출력
        System.out.println("====================================");
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {// 자료구조안에 값이 있는지 체크해서 있으면 true를 반환하고 ,없으면 false반환
            String key = iter.next();
            // String value=(String)mt1.rMap.get(key);//리턴이 object String으로 형전환
            Object value = mt2.rMap.get(key);// Object로 받으면//ClassCastException Integer를 String으로 못바꿈

            System.out.println(key + ":" + value);
        }
    }
}
