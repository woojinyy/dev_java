package dev_java.qwer;

public class TwoArray1 {

    void arr() {
        int arr[][] = new int[2][3];
        int i = 0;

        while (i < arr.length) {
            int j = 0;
            while (j < arr[i].length) {// 
                System.out.println("arr[" + i + "][" + j + "]=" + arr[i][j]);

                j++;
            }
          
            i++;
        }
    }
    public static void main(String[] args) {

        TwoArray1 arr1 = new TwoArray1();
        arr1.arr();
    }
}


