package dev_java.Exam1208;

public class Q3 {
    public static void main(String[] args) {
        int [] arr= new int[4];// [  ,   ,   ,   ]
     
        for (int i=0; i<=arr.length; i++){
            try {
                   arr[i]+= (10+i);//10 11 12 13
                System.out.println(arr[i]);
                
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.toString());//오류 출력
            }
         
        }
    }
}
