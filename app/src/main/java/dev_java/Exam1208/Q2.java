package dev_java.Exam1208;

public class Q2 {
     void count(){
          for (int i = 1; i <= 20; i++) {
               if (i % 5 == 0) {
                    System.out.println(i + " : 5의배수 입니다");
               } else {
                    System.out.println(i + " : 5의배수가 아닙니다");
               }
          }
     }
     void count2(){
          for(int j=1; j<=20 ;j++){
          switch (j%5) {
               case 0:
                    System.out.println(j + " : 5의배수 입니다");
                    break;

               case 1,2,3,4:
                    System.out.println(j + " : 5의배수가 아닙니다");
                    break;
     }
}
     }
     public static void main(String[] args) {
          Q2 test1 = new Q2();
          test1.count();
          Q2 test2= new Q2();
          test2.count2();
                    }
               }