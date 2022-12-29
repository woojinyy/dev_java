package dev_java.waek3.Lecture1216;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Vector6 {
    
    Vector<String[]> vinf = new Vector<>();
    String inf[][] = {
                { "10", "개발부", "서울" }
                , { "20", "인사부", "인천" }
                , { "30", "총무부", "부산" }
        };
    void initVectorPoint() {
        for (int i = 0; i < vinf.size(); i++) {// 벡터의 행
            String[] oneRow = vinf.get(i);
            System.out.println(oneRow.toString());
            for (int j = 0; j < oneRow.length; j++) {
                System.out.print(oneRow[j]);
            }
        }
    }
void remove() {
        System.out.print("삭제할 부서번호를 입력");
        Scanner s = new Scanner(System.in);
        int users = 0;
        users = s.nextInt();
        for(int i =0; i<vinf.size();i++){
            String[] oneRow=vinf.get(i);
            if(users==Integer.parseInt(oneRow[0])){
                vinf.remove(i);
            }
        }
        //삭제한 뒤 남은 정보 출력
        System.out.println(vinf);
    s.close();
    }

    public static void main(String[] args) {
        Vector6 v100=new Vector6();
        v100.initVectorPoint();
        v100.remove();
        
        
        // System.out.println(vinf.get(i));
        // System.out.println(Arrays.toString(vinf.get(i)));//배열 주소를 스트링으로 변경
        // System.out.println(vinf.get(i));//주소값
    }
}
