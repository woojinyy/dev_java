package dev_java.waek3.Lecture1216;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Vector61 {
    Vector<String[]> vinf = new Vector<>();
        String inf[][] = {
                { "10", "개발부", "서울","02-555-6666" }
                , { "20", "인사부", "인천","032-123-4567"}
                , { "30", "총무부", "부산","051-888-9999" }
        };

        void initVector() {
            for (int i = 0; i < inf.length; i++) {
                vinf.add(inf[i]);//벡터안에 1차배열  컬럼의 수는 바뀔 수 있음
            }
        }
        void initVectorPoint(){
            for(int i=0;i<vinf.size();i++){//벡터의 행
                String[]oneRow=vinf.get(i);
                System.out.println(oneRow.toString());
                for(int j =0;j<oneRow.length;j++){
                    System.out.print(oneRow[j]);
                }
                System.out.println("\n");

            }
        }

        public static void main(String[] args) {
            Vector61 v61 = new Vector61();
            System.out.println(v61.vinf.size()); // initVector 메소드를 경유하지 않았으므로 size는 0
            v61.initVector();//메소드 경유 해서 size증가0->3
            //vinf.get(0)->{ "10", "개발부", "서울","02-555-6666" }
            //vinf.get(1)->{ "20", "인사부", "인천","032-123-4567"}
            //vinf.get(2)->{ "30", "총무부", "부산","051-888-9999" }
            v61.initVectorPoint();
           
        }

    }
