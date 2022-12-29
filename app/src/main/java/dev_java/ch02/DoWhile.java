package dev_java.ch02;

public class DoWhile {//while문과 do_while문 비교
    public static void main(String[] args) {
        int i =1;//1로 초기화
        while(i>3){//조건 비교시 false
            System.out.println("while실행문 출력");//false라 실행 X

        }
       System.out.println("false시 실행");
        i=1;// 같은 조건 비교 하기위해 같은 값 초기화 해줘야해
        do{//조건을 나중에 확인한다=무조건 한번은 실행한다
                System.out.println("do_while문 일단실행한다");
        }while(i>3);//같은 비교조건식
    }
}
