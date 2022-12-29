package dev_java.weak4;

public class Array3 {
    public static void main(String[] args) {
        //String[] sArr = {"빨강", "노랑", "파랑"};
        String[]   sArr=new String[] {"빨강","노랑","파랑"};
   

        for (int i=0; i<sArr.length;i++){
            System.out.print(sArr[i]);
       }
       for(String sArrs:sArr){
        System.out.println(sArrs);
       }
    }
}
