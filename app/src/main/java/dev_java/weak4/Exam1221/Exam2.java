package dev_java.weak4.Exam1221;

import java.util.Scanner;

//클래스 하나당 기능 하나
class exam2{
    public void methodA(){
        System.out.println("수정 1 삭제 2입력");
        Scanner s= new Scanner(System.in);
        int choice=0;
        choice =s.nextInt();
        if (choice>2||choice<0){
            System.out.println("1혹은 2를 입력해");
           // return; 조건문안에 return은 끝내자
        }else{
            System.out.println("정상");
        }
        while(0<2){// 무한루프 방지 코드 작성 해라 좀비쉑
                                //while문 안에 증감연산자가 있는지 확인해라 뒤지기싫으면
            if(2==2)break;// ex) 반복문 아이디 중복검사 500번째 아이디가 있으면 나와야지 언제 25억개 다 돌려봄??
        }
        //빠져나오고 싶은데 어쾀??????????????????
    }
}

public class Exam2 {
    public static void main(String[] args) {
        exam2 e2=new exam2();
    }
}
