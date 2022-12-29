package dev_java.waek3.Quiz1215;
/*
연습문제1
키보드로 부터 5개의 정수를 입력 받아서 배열에 저장하세요.
그리고 이들의 합계와 평균을 출력하는 프로그램을 작성하시오.
 */

import java.util.Scanner;

public class Quiz1 {
    //배열 선언
    int a[]=new int[5];//00000
    void average(int sum){
        double avg=0.0;//지역변수 초기화
        avg=sum/(double)a.length;
        System.out.println("평군"+avg);
    }
    int sum(){
        int sum=0;//지역변수는 초기화 해야한다 이 안에서만 유지된다.
        for(int i=0;i<a.length;i++){
        sum+=a[i];
        System.out.println("합");
        }
        return sum;
    }
 
    void initUsers(){
        Scanner s =new Scanner(System.in);
        for(int i=0;i<a.length;i++){
            System.out.print("정수 입력");
            a[i]=s.nextInt();
            System.out.println(a[i]);
           
        }
        s.close();
    }
    public static void main(String[] args) {
        Quiz1 q1= new Quiz1();
        q1.initUsers();
        int hap=q1.sum();
        q1.average(hap);

    }
}
