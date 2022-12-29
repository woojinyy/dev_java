package dev_java.ch02;

public class For1 {

    public static void main(String[] args) {
        for(int i=1; i<=3; i++){
            System.out.println(i);
        }
        int i= 0;
        while(i<=3){
                System.out.println(i);//무한루프에 주의할것 
                                                     //증감연산자 유무를 확인한다
                i++;
                
        }
    }
}
