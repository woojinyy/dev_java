package dev_java.waek3.Lecture1216;

import java.util.Vector;

public class Vector5 {    //과일 중 좋아하는 과일만 골라서 Vector에 담아주세요
    public static void main(String[] args) {
        String fruits[]={"키위","포도","사과","토마토","메론","파인애플","바나나","복숭아"};
    //과일가게의 진열 상품
        Vector<String> f = new Vector<>(); 
        f.add("키위");
        f.add("복숭아");
        for(int i=0;i<f.size();i++){
        System.out.println(f.get(i));
        }
        Vector<String> vfruit=new Vector<>();
        String myFruits[]={"키위","복숭아","사과","바나나","딸기"};
        //내가 고른 상품
        for(int i=0;i<fruits.length;i++){
            for(int j=0;j<myFruits.length;j++){
                if(fruits[i].equals(myFruits[j])){
                    vfruit.add(fruits[i]);

                }

            }
        }//end of for
        //선택 상품 출력
        System.out.print("진열상품 중 선택 한 상품");
        for(String d:vfruit){
            
        System.out.print(d);//출력 순서 비교는 String[] 이다 내가 선택한게 아니야
        }
        
    }//end of main
}
