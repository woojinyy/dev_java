package dev_java.ch02;

public class Quiz2 {
    public static void main(String[] args) {
        // 합을 담을 변수 선언
        int tot = 0;
        int count = 1;
        for (; count <= 10; count = count + 1) {
            // for(초기화;조건식;증감)
            //if(count%2==0)//짝수니?
            if(count%2==1)//홀수니?
                {tot= tot+count;
            }
          // System.out.println("tot:" + tot + "count :" + count);
        }
        //System.out.println("tot:" + tot + "count :" + count);
        System.out.printf("tot:%d,count%d%n",tot,count);
    }
}

