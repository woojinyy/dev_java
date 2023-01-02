package dev_java.basic1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExam1 {
    public static void main(String[] args) {
        /*
         * List 따로 Map따로 보다
         * 주로 List<Map<>>꼴로 많이 사용됨
         * 오라클에서 제공되는 테이블 구조에서 튜플을 구성할 때 Map을 사용가능하다
         * Member테이블 기준으로 코드 작성
         */
        // id, nick pw
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> pmap = new HashMap<>();// t싱글스레드에서 안전한 해쉬맵 쓰자
        pmap.put("mem_id", "kiwi");
        pmap.put("mem_pw", "123");
        pmap.put("mem_nick", "나초보");
        list.add(pmap);// list.get(0)
        // System.out.println(pmap);
        pmap = new HashMap<>();// 새로운 주소번지가 할당 된다.
        pmap.put("mem_id", "tomato");
        pmap.put("mem_pw", "123");
        pmap.put("mem_nick", "나신입");
        list.add(pmap);// list.get(1)
        // System.out.println(pmap);
        pmap = new HashMap<>();
        pmap.put("mem_id", "banana");
        pmap.put("mem_pw", "123");
        pmap.put("mem_nick", "나를봐");
        list.add(pmap);// list.get(2)
        // System.out.println(pmap);
        // 키값 - mem_id., mem_pw, mem_nick
        // Map의 키 값은 오라클 DB테이블의 컬럼명과 통일하기
        Object key[] = pmap.keySet().toArray();
        for (Object s : key) {
            System.out.println(s);
            System.out.println(pmap.get(s));
        }
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> rmap = list.get(i);
            System.out.println(rmap.get("mem_id") +
            ","+ rmap.get("mem_pw")+
            ","+ rmap.get("mem_nick"));

        }
    }
}
