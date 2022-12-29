package dev_java.waek3.Quiz1215;
/*
 * 연습문제 3
0 부터 9사이의 임의의 수를 100개를 채번하여 한 줄에 10개씩
  출력하고 그 숫자의 빈도수를 계산하여 출력하시오
 */

public class Quiz3 {
    int counts[] = new int[10];//전역변수

    int[] initArray(int datas[],int size){
        int i;
        for(i=0;i<datas.length;i++){
            datas[i]=(int)(Math.random()*10);
        }
        dataPrint(datas);
        return datas;
    }
    
    void dataPrint(int[] datas) {
        for (int i = 0; i < datas.length; i++) {
            System.out.print(datas[i]);
            if (i % 10 == 9) {
                System.out.println("\n");
            }
        }
    }

    void check(int[] datas) {
        int index=0;
        for(int i =0;i<10000;i++){
            index= datas[i];
            counts[index]++;
        }
    }
    public static void main(String[] args) {
        Quiz3 q3= new Quiz3();
        int datas[]=new int[10000];
        q3.initArray(datas,10000);//call by value
        q3.check(datas);
        for(int i = 0; i  <q3.counts.length;i++){
            System.out.print(q3.counts[i]+" ");
        }



    }
    
}
