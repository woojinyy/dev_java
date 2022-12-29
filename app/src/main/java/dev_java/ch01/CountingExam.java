package dev_java.ch01;

public class CountingExam {

    public void Count(int i, int j) {//call by value 지변의 값은 호출될 떄 결정됨
         
         j=++i;//밖에서 호출하려면 인스턴스화 해줘야해
         System.out.println("i="+i+ "j="+j);
    }
    public void CountB(int i,int j) {
        j*=i;
    }
    public static void main(String[] args) {
      
   CountingExam count=new CountingExam();
   count.Count(1,2);


     

        int a=1;
        int b= a++;
        System.out.println(a);//2
        System.out.println(b);//1 대입 후 증가시켜서 a=2 b=1

        int c =2;
        int d=--c;// d=(c-1)
        System.out.println(c);
        System.out.println(d);

        int e =2;
        int f=e--;
        System.out.println(e);//2   후행한 값이 들어가니까 1
        System.out.println(f);//1   후행이니까 2
    }
}
