package dev_java.waek3;

public class Sub_2 {

    public static void main(String[] args) {
        Main_2 m1 = new Main_2();//인스턴스화
        for (int i = 0; i < m1.isOk.length; i++) {//length 배열의 길이
            //Main_2에서 아직 length 길이 선언x -> NullPointException에러
            System.out.println(m1.isOk[i]);
        }
        System.out.println("=======================");
        for (boolean isOk : m1.isOk) {// 개선된 for문 전체에 대한
            System.out.println(isOk);
        }
    }
}
