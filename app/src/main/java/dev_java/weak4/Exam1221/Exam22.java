package dev_java.weak4.Exam1221;

import java.util.Scanner;

public class Exam22 {
    public void sum(){
        Scanner s = new Scanner(System.in);
        System.out.println("1이상의 숫자입력");
        int num = s.nextInt();
        int sum=0;
        if (1<=num){
            int i =1;
            while(i <=num){
                sum +=i;
                i++;
                
            }
            System.out.println("1부터 "+num+"까지의 합은"+sum+"입니다.");
        }else{
            System.out.println("숫자가 1이상이 아닙니다.");
        }
    }
    public static void main(String[] args) {
        Exam22 e2= new Exam22();
        e2.sum();
        
    }
}
