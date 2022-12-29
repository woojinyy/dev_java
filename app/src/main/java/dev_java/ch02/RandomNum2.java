package dev_java.ch02;

import java.util.Scanner;

//변수 이름을 바꿔가며 
public class RandomNum2 {// 선언 & 초기화
    int com[] = new int[3];// 컴퓨터가 고른 숫자
    int my[] = new int[3];// 사용자가 입력한 숫자

    public void ranCom() {// 컴퓨터 난수 입력받기

        // 반환값이 void야 Q. 전역변수 쓸래? 지역변수 쓸래?
        // A. 전역변수(=멤버변수,글로벌변수)
        com[0] = (int) (Math.random());// 첫번째 자리의 숫자
        do {
            com[1] = (int) (Math.random() * 10);// 두번째 자리의 숫자

        } while (com[0] == com[1]);
        do {
            com[2] = (int) (Math.random() * 100);// 세번째 자리의 숫자

        } while (com[2] == com[0] || com[2] == com[1]);
    }

    // Q1. 초기화 전역변수? 지역변수?A.지역변수 게임마다 초기화 해야해
    // Q2. 자리가 같다는 것을 배열의 index를 활용하시오
    /*
     * / public String account(String user_input) {
     * return "1S1B";
     * }
     */
    public void userscan() {// 사용자 숫자 입력 method


     
        Scanner scanner = new Scanner(System.in);
        System.out.println("세자리 숫자 입력 : ");
        my[0]=scanner.nextInt()/100;
        my[1]=scanner.nextInt()%100/10;
        my[2]=scanner.nextInt()%10;

        for (int n=0;n<3;n++){
            my[n]=scanner.nextInt();
        }
        System.out.println(my[0]+" "+my[1]+" "+my[2]);

    }

    public void match() {// 비교
        int i = 0;
        int j = 0;
        int strike = 0;
        int ball = 0;
       boolean result = false;
      /*   temp = Integer.parseInt(System.in);// 입력받은 숫자 비교
        my[0] = 256 /100;// 2.56
        my[1] = 256 % 100;// 2.56/10
        my[2] = 256%10 ;// 25.6*/

        while (i<3) {
            while(j<3){
            if (my[i] == com[j]) {// 숫자가 같다면
                if (i == j) {// 위치도 같니?
                    strike += 1;
                    System.out.print(strike + "S");

                } else {
                    ball += 1;
                    System.out.print(ball + "B");
                }
            }j++;
        }i++;
        j=0;
        if (strike==3)
        System.out.println("out");
   
        
    }
       
    }

    public static void main(String[] args) {
        RandomNum randomNum = new RandomNum();// 인스턴스화 > 변수사용
        randomNum.ranCom();// ranCom 호출
        RandomNum2 scan = new RandomNum2();
        scan.userscan();
        RandomNum2 Match = new RandomNum2();
        Match.match();
        for (int i = 0; i < 10; i++) {
            randomNum.ranCom();// RandomNum 메서드를 호출
            System.out.println(randomNum.com[0] + "" + randomNum.com[1] + "" + randomNum.com[2]);
        }
    }
}
