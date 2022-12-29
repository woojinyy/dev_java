package dev_java.weak4;

public class Array {
    public static void main(String[] args) {
        String[]    sArr=new String[3];
      
        System.out.println(sArr[0]);
        System.out.println(sArr[1]);
        System.out.println(sArr[2]);
        sArr[0]="사과";
        System.out.println(sArr[0]);
        sArr[1]="딸기";
        System.out.println(sArr[1]);
        sArr[2]="오렌지";
        System.out.println(sArr[2]);
    }
}
