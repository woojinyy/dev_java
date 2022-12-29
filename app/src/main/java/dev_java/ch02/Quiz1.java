package dev_java.ch02;

public class Quiz1 {
    public static void main(String[] args) {
        //합을 담을 변수 선언
        int tot=0;//main method안에 선언했어 ->지역변수라 초기화 해야해
        //1씩 셈 하는 변수 선언
        int count=1;
        for(;count<=3;count=count+1){
        //for(초기화;조건식;증감)
        tot=tot+count;
                System.out.println("tot:"+tot+"count :"+count);
        }
    }
}
