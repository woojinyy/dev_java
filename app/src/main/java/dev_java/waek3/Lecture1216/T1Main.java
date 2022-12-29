package dev_java.waek3.Lecture1216;

class T1{
    int i =1;
}

public class T1Main {
    public static void main(String[] args) {
        T1 t1= new T1();
        T1[] t1s=new T1[3];//
        t1s[0]=t1;
        System.out.println(t1);//@4517d9a3
        System.out.println(t1s[0]);//@4517d9a3

        t1= new T1();
        t1s[0]=t1;
        System.out.println(t1);//@372f7a8d
        t1=new T1();
        t1s[0]=t1;
        System.out.println(t1);//@2f92e0f4
   //     T1[] t1s=new T1[3];
     //   for(T1 t:t1s){
       //     System.out.println(t+"");
        //}
     
     t1s[0]=new T1();//초
     t1s[1]=new T1();//기
     t1s[2]=new T1();//화
        for(int i=0;i<t1s.length;i++){
            System.out.println(t1s[i]);
        }
    }
    
}
