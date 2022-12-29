package dev_java.ch02;

public class P21_4 {
    public static void main(String[] args) {
        int i=1;
        int j=2;
        if((i!=--j)||(++i<=j)){//or연산자 tf=t ft=t tt=t ff=f 
            System.out.println("조건만족");
        }else{
            System.out.println("조건만족안함");

        }
        System.out.println("i="+i+",j="+j);
    }
}
