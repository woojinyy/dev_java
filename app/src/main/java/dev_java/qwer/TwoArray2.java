package dev_java.qwer;

public class TwoArray2 {
    public static void main(String[] args) {//2차배열 선언 초기화
        int arr[][]= new int [3][3];
        arr[0]=new int[]{1,2,3};
 
         arr[1]=new int[]{1,2,3,4};

         arr[2]=new int[]{1,2,3,4,5};
        System.out.println(arr[2][4]);
    }
}
