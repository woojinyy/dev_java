package dev_java.ch02;

public class Fibonacci3 {// method로 꺼내서 해보자
    void action() {
        int a1 = 1;
        int a2 = 1;
        int a3 = 0;
        System.out.print(a1+" "+a2+" ");
        for (int i = 0; i < 8; i++) {
            a3 = a2 + a1;
            System.out.print(a3 + " ");
            a1 = a2;// 이전전항을 이전항으로
            a2 = a3;// 이전항을 현재항으로
        }
    }
    

    public static void main(String[] args) {
        
  Fibonacci3 f1= new Fibonacci3();//인스턴스화
  f1.action();//  호출
    }
}

/*
 * int i=1;
 * int j=1;
 * int sum=0;
 * int sum1=0;
 * int sum2=0;
 * int sum3=0;
 * int sum4=0;
 * int sum5=0;
 * int sum6=0;
 * int sum7=0;
 * sum=i+j;
 * sum1=sum+j;
 * sum2=sum1+sum;
 * sum3=sum2+sum1;
 * sum4=sum3+sum2;
 * sum5=sum4+sum3;
 * sum6=sum5+sum4;
 * sum7=sum6+sum5;
 * System.out.println(i);
 * System.out.println(j);
 * System.out.println(sum);
 * System.out.println(sum+j);
 * System.out.println(sum1+sum);
 * System.out.println(sum2+sum1);
 * System.out.println(sum3+sum2);
 * System.out.println(sum4+sum3);
 * System.out.println(sum5+sum4);
 * System.out.println(sum6+sum5);
 * System.out.println(sum7+sum6);
 * 
 * 
 * }
 */
