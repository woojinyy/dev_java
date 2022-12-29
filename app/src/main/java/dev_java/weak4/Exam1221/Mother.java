package dev_java.weak4.Exam1221;

import java.util.Vector;

public class Mother {
    Money m = new Money(1000);
    public static void main(String[] args) {
        Vector<Mother> v =new Vector<>();//0
        v.get(0).m.money=20000;
        Mother m1 = new Mother();
    v.add(0,m1);//0번째에 엄마1를 넣고
        Mother m2 = new Mother();
    v.add(1,m2);//1번째에 엄마2를 넣고
    v.get(1).m.pay(1000);//1번째 엄마2가 pay1000원
        Mother m3 = new Mother();
    v.add(2,m3);//2번째에 엄마3를 넣고

    /*/
    for(Mother m:v){//for (타입 변수명 : 컬렉션 또는 배열)
        System.out.println(m);
    }
    */

    for(int i =0;i<v.size();i++){
        Mother mth=v.get(i);
        System.out.println(mth.m.money);
       // System.out.println(m);
        //System.out.println(m.toString());//주소번지 찍기
    }
    }
}
