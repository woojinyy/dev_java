package dev_java.ch01;

public class P21_1 {
    public static void main(String[] args) {
        int i=1;
        switch(i){
            case 0 : //실행문 값이 0 ->진행 x
            ++i;
            case 1:
            ++i;
            break;// ㅃ2
            default:
            ++i;
            System.out.println(i);//2  땡 3이래 Q. 왜?? A. break만날때까지 돈다 
        }
    }
}
