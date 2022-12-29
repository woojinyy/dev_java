package dev_java.pattern;

import java.util.Arrays;
import java.util.Scanner;

import org.checkerframework.checker.units.qual.Length;

public class HintPart1 {
    //선언부 
    //변수 세개 
    //1 컴퓨터 채번 담을 변수
    int com[]=new int[3];// 난수발생해야해 초기화 x 
    //2 사용자 입력 값 100,10,1자리 담을 변수
     int my [] = new int[3];
     // 회차를 담을 변수
     int cnt=0;
    //3 값이 같으면 B 자리도 같으면 S
    // 새게임 버튼을 누르면 3자리의 서로 다른 숫자를 채번한다.
    public void ranCom(){//컴퓨터 난수 입력
        com[0]=(int)(Math.random()*10);
        do{//중복된 숫자를 제거하는 목적으로 do while 선택
            com[1]=(int)(Math.random()*10);
        }  while(com[0]==com[1]);
        do{
            com[2]=(int)(Math.random()*10);
        }  while(com[0]==com[2] || com[1]==com[2]);
    }
    //3자리 숫자를입력받아서 힌트문을 작성해주는 메소드 구현
    public String account(String user){
        String userin = null;// 입력
        if (user.length() !=3){
            return"세자리 숫자만 입력";//account method 탈출하기
        }
        int temp = 0; //파라미터로 넘어온 사용자가 입력한 문자열 값을 정수형으로 변환
        int strike=0;
        int ball=0;
        try {
            temp=Integer.parseInt(user);
        } catch (NumberFormatException e) {
        return "숫자만 입력하세요";
        }
        my[0]=temp/100;// 백의 자리숫자만 담는다
        my[1]=(temp%100)/10;//십의 자리숫자만 담는다 소숫점은 담을 수 없다 왜? 타입이 달라서
        my[2]=temp%10;//일의 자리숫자만 담는다.
        for(int i=0;i<com.length;i++){//입력받은 숫자가  com 배열에 존재하니? Y-> B     N->O
            for(int j=0;j<com.length;j++){//만일 위조건이 Y라면 Strike 검사한다.com 배열의 i자리와 my배열의 j
            if(com[i]==my[j]){//같은 숫자가 있는지만 비교하고 자리가 달라도 참
                //볼은 확보 -> 스트라잌 비교
                if(i==j){//먼저 비교한 숫자의 자리가 사용자 입력숫자의 자리와 같으면S
                    strike ++;
                }else{//아니면 B
                    ball++;
                }
            }//////////입력받은 숫자가 컴퓨터 채번한 숫자와 일치하는 경우
            }//////////end of inner for 문
        }////////////edn of outter for문
        if (strike==3)return"정답입니다";
        return strike+"스"+ball+"볼";
       // public void game() {
            
        }
    
    public static void main(String[] args) {
        //컴퓨터 난수 입력 호출
        HintPart1 컴퓨터입력=new HintPart1();
        컴퓨터입력.ranCom();
         System.out.println("ranCom값: " + 컴퓨터입력.com[0] + 컴퓨터입력.com[1] + 컴퓨터입력.com[2]);
        System.out.println("사용자 입력");
        HintPart1 사용자입력= new HintPart1();
        String userin = null;// 입력
        int user = Integer.parseInt(userin);
        사용자입력.account(userin);



    }
}
