package dev_java.ch02;

import java.util.Scanner;

//변수 이름을 바꿔가며 
public class RandomNum {
    int com[]=new int[3];//컴퓨터가 고른 숫자
    int my[]=new int[3];// 사용자가 입력한 숫자
    // 자릿수 or 숫자만 맞으면 Ball{ for{자릿수 and 숫자 맞으면 Strike},else{다 틀리면 Out}}
    public void ranCom(){//너도 나도 쓰자 public
        //세자리 서로다른 수 배열에 저장
        //반환값이 void야 Q. 전역변수 쓸래? 지역변수 쓸래?
        //A. 전역변수(=멤버변수,글로벌변수)
        com[0]=(int)(Math.random()*10);//첫번째 자리의 숫자
        do{
            com[1]=(int)(Math.random()*10);//두번째 자리의 숫자

        }while(com[0]==com[1]);
        do{
            com[2]=(int)(Math.random()*10);//세번째 자리의 숫자

        }while(com[2]==com[0]|| com[2]==com[1]);
    }
    //Q1. 초기화 전역변수? 지역변수?A.지역변수
    //Q2. 자리가 같다는 것을 배열의 index를 활용하시오
        public String account(String user_input){
            return "1S1B";

    }
    public void userscan(){//사용자 숫자 입력
         //사용자 입력 스캐너
        int my=0;
       //사용자 입력 숫자
      /* temp=Integer.parseInt(null);//입력받은 숫자 비교
        my[0]=256%100;//2.56
        my[1]=256%100;//5.6
        my[2]=256%10;//25.6*/
    }
    public static void main(String[] args) {
        int my=0;//사용자 입력값 초기화
       
        Scanner scanner = new Scanner(System.in);
        my=scanner.nextInt();
     
     
        RandomNum randomNum =new RandomNum();// 인스턴스화 > 변수사용
            randomNum.ranCom();//ranCom 호출
       
        System.out.println("중복 없는 세자릿 수 입력");
        
        
           
            
            for(int i=0; i<10;i++){
                randomNum.ranCom();// RandomNum 메서드를 호출
                System.out.println(randomNum.com[0]+""+randomNum.com[2]+""+randomNum.com[3]);
     }
    }
    }

