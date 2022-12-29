package dev_java.weak4;

import java.util.Map;
import java.util.Vector;

public class Vector21 {
    public static void main(String[] args) {
        // 2중for문 돌림 outter = vector, inner = String[]
        // 끼워넣기 가능,수정에대한 API 없다 클라우드 기반 데이터베이스 제품들이 이런식
        Vector<String[]> v = new Vector<>();
        Vector<Map<String,Object>> v3= new Vector<>();// 실무사용패턴
        String imsi[] = { "10", "개발부", "서울" };
        v.add(imsi);//0행
        imsi = new String[] { "20", "총무부", "인천" };
        v.add(imsi);//1행
        for (int x = 0; x < v.size(); x++) {// 로우의 수 2번 반복
            
            for (int i = 0; i < imsi.length; i++) {// 컬럼의 수 3번반복
                String[] r = v.get(x);
                System.out.print(r[i] + "");
        }
        System.out.println();
    }
        // 크기가 얼마인가요? 
        // 단일 for문 처리 가능
        Vector<String> v2 = new Vector<>();
    }
}
