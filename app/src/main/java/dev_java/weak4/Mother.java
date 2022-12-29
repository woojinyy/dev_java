package dev_java.weak4;

import java.util.Vector;

public class Mother {
    //Money m = new Money(1000);
    public static void main(String[] args) {
        Vector<Mother> v =new Vector<>();//0
        Mother m1 = new Mother();
    v.add(0,m1);//0번째에 엄마1를 넣고
        Mother m2 = new Mother();
    v.add(0,m2);//0번째에 엄마2를 넣고
        Mother m3 = new Mother();
    v.add(0,m3);//0번째에 엄마3를 넣고
    for(Mother m:v){//for (타입 변수명 : 컬렉션 또는 배열)
        System.out.println(m);
    }
    for(int i =0;i<v.size();i++){
        Mother m=v.get(i);
        System.out.println(m);
        System.out.println(m.toString());//주소번지 찍기
    }
    }
}
