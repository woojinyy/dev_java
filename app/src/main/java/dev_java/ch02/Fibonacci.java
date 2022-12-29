package dev_java.ch02;

public class Fibonacci {
    public static void main(String[] args) {
        int ppn =1;//이전전 항
        int pn=1;//이전항
        System.out.print(ppn+" "+pn+" ");
        for(int i=3;i<11;i++){
         int cn=   ppn+pn;//현재항
         System.out.print(cn+" " );//출력을 하고
         ppn=pn;//바꿔
         pn=cn;

        }
        }
}
/*int i=1;
int j=1;
int sum=0;
int sum1=0;
int sum2=0;
int sum3=0;
int sum4=0;
int sum5=0;
int sum6=0;
int sum7=0;
sum=i+j;
sum1=sum+j;
sum2=sum1+sum;
sum3=sum2+sum1;
sum4=sum3+sum2;
sum5=sum4+sum3;
sum6=sum5+sum4;
sum7=sum6+sum5;
System.out.println(i);
System.out.println(j);
System.out.println(sum);
System.out.println(sum+j);
System.out.println(sum1+sum);
System.out.println(sum2+sum1);
System.out.println(sum3+sum2);
System.out.println(sum4+sum3);
System.out.println(sum5+sum4);
System.out.println(sum6+sum5);
System.out.println(sum7+sum6);


}
*/
