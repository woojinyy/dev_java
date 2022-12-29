package dev_java.ch02;

import java.util.Scanner;

public class Quiz2_1 {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.println("구하고자 하는 합의 두번째 숫자를 입력해");
        int user_end=s.nextInt();
        int tot = 0;
        int count = 1;
        for (; count <= user_end; count = count + 1) {//입력하는 값까지 범위
            // for(초기화;조건식;증감)
            // if(count%2==0)//짝수니?
            if (count % 2 == 1)// 홀수니?
            {
                tot = tot + count;
            }
            // System.out.println("tot:" + tot + "count :" + count);
        }
        // System.out.println("tot:" + tot + "count :" + count);
        System.out.printf("tot:%d,count%d%n", tot, count);
    s.close();//일회용
    }
}
