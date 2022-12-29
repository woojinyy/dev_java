package dev_java.oracle;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest3 {
    // 회원정보사람3명 개인정보4가지
    // //id, 성별, 비번, 전화번호 
    //mem_id,mem_gender,mem_pw,mem_phone 키값
    // tom 톰,남,123, 1111
    // alex 알,남,456,2222
    // jin 진, 남 789,3333

    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<>();//
        Map<String, Object> rMap = new HashMap<>();//
        rMap.put("mem_id", "tom");
        // System.out.println(rMap);//toString없어도 toString이랑 똑같다
        // System.out.println(rMap.toString());
        rMap.put("mem_gender", "남");
        rMap.put("mem_pw", "123");
        rMap.put("mem_phone", "1111");
        list.add(rMap);
        System.out.println(list.get(0));
        System.out.println(list.get(0).get("mem_id"));
        rMap = new HashMap<>();
        rMap.put("mem_id", "alex");
        rMap.put("mem_gender", "남");
        rMap.put("mem_pw", "456");
        rMap.put("mem_phone", "2222");
        list.add(rMap);
        rMap = new HashMap<>();
        rMap.put("mem_id", "jin");
        rMap.put("mem_gender", "남");
        rMap.put("mem_pw", "789");
        rMap.put("mem_phone", "3333");
        list.add(rMap);
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> m1 = list.get(i);
            Object[] keys = m1.keySet().toArray();
            for (int j = 0; j < keys.length; j++) {
                String key = (String) keys[j];
                System.out.println(m1.get(key) + " ");
            }

        }

    }
}
