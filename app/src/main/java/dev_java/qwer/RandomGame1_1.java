package dev_java.qwer;

import java.util.Scanner;

import org.checkerframework.checker.units.qual.s;

public class RandomGame1_1 {
    int com=0;
   
    int my =0;//필요없다 compare메서드에서 받아 지역변수로 받을거니까
    public void ranCom(){//전역변수 쓴다 ->왜? 비교해야하니까, 리턴타입 필요 없다.
        com=(int)(Math.random()*10);//10을 곱하는 이유는 구간을 늘리기 위함
    }
    
    //user변수 때문에 my변수가 필요없다
    //Q1.사용자가 입력한 값을 지역변수에 달아야 하는 이유에 대해 설명하시오
    //A1. 재사용시 초기화 필요 -> 지역변수 쓰자
    //Q2.com변수는 왜 전역변수여야만 하는지 설명하시오
    //A2. 기준 변하면 안돼 전역변수 쓰자
    public String compare(int user){ //비교하기
        String msg=null;
        //시도할 때 마다 초기화 해야해 -> 지역변수
        if(com>user){//정답보다 입력한 값이 작니?
                msg="높여라";
        }else if(com<user){//정답보다 입력한 값이 크니?
                msg="낮춰라";
        }else if(com==user){
            msg = "정답";
            //정답을 맞췄으면 이 메서드를 빠져나가자 -> return
           // return msg; 킹치만 if문에서 해당 메서드를 탈출할 때 return 예약어 사용 가능
           //반복문에서는 break문 사용한다.
        }
        return msg;
    }
    public static void main(String[] args) {
     
        //실행하자 마자 채번하기
        //생성자 역할 = 전역변수 초기화,부모클래스 초기화 포함(상속)
        
        RandomGame1_1 rc =new RandomGame1_1();
                //컴퓨터가 숫자 랜덤뽑기한 값으로 초기화 하는 메소드
                  //컴퓨터가 숫자 랜덤뽑기한 값 출력 호출
        rc.ranCom();//새 게임 누르면 재사용or 정답
        RandomGame1_1 c=new RandomGame1_1();
       

        //컴퓨터가 채번한 숫자를 출력
        System.out.println("컴퓨터가 채번한 숫자"+rc.com);//전역변수다 >>인스턴스변수가 필요하다
                  //>> 게임을 하는 동안 값이 유지된다

        //Scanner를 활용하여 사용자가 입력한 값을 받으시오
        Scanner scanner= new Scanner(System.in);//매번 새로운 숫자 받아 > 반복문안에 해야겠네
            int i=1;//회차 표시 지역변수 사용한다 너랑 나랑 다르잖아?
            String userin=null;//입력
            String userreturn=null;//반환
        
        
        
        /*System.out.println("세자리 숫자 입력 : ");
            my[0]=scanner.nextInt()/100;
            my[1]=scanner.nextInt()%100/10;
            my[2]=scanner.nextInt()%10;*/

                    //게임 기회는 5회로 제한
        while(i<=5){//무한루프 방지 break; 작성해라 뒤지기싫으면
            System.out.print("0부터9사이 숫자입력");
            userin=scanner.nextLine();//사용자가 입력한 값 받기 nextLine()은 반환값이 있다.
            System.out.println(userin);//입력값  null아닌지 확인
                      //exception -> NullPointerException
            int user = Integer.parseInt(userin);//numberformatexception
            userreturn=rc.compare(user);
        if("정답".equals(userreturn)){
                      //for(int chance=5;chance>0; chance--){
                        System.out.println("ㅊㅋ");//새게임 할거면 i를 초기화 하면 되잖아?
                        //굳이 while문 나갈 필요 없잖아
                        
                        
        break;
        }
                 //시도 할 때 마다 몇번째 기회를 사용하는지 출력
        System.out.println(user+" : "+userreturn);
        i++;
    }//end of while
        scanner.close();
                        //정답을 맞추었을 경우 축하 새게임 진행 여부 확인

    }
    

}