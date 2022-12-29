package dev_java.waek3.Quiz1215;
/*
 * 연습문제 2
-10에서 10사이의 정수 10개를 랜덤하게 채번하여  음수와 양수의 합계를 구하는 프로그램을 작성하시오.
출력)
배열 : 9 -2 -3 8 0 -3 -8 -6 -2 0
음수합 : -24
양수합 : 17
 */

//변수의 개수 : 양수의 합 phap, 음수의 합 nhap 
//전역변수로 처리해야 하는 변수는? 배열 randoms
//int randoms[] = new int[10];

//메소드 선언하기 
//배열 초기화 void setArray(int size)  size변수로 활용도는 높다
//합  void total(){ phap nhap}
//난수 수집 체크 void randomsPrintf(){
//
//}

public class Quiz2 {
    int randoms[] = new int[10];
    int users[]=null;
    int phap,nhap=0;

    void setArray() {
        randoms = new int[10];
        for (int i = 0; i < randoms.length; i++) {
            randoms[i] = (int) (Math.random() * 21 % 21 - 10);
        }
    }

    void setArray(int size) {
        users = new int[size];
        for (int i = 0; i < size; i++) {
            users[i] = (int) (Math.random() * 21 % 21 - 10);
        }
    }
    
    void total(){ 
        for (int i = 0; i < randoms.length; i++) {
            if (randoms[i] > 0) {
                phap+=randoms[i];
            }else{
                    nhap +=randoms[i];
                }
            }
            System.out.println("양수 합 : "+phap);
            System.out.println("음수 합 : "+nhap);
            int total= phap+nhap;
            System.out.println("총합 "+ total);
        }
   
    

    
    void randomsPrintf(){
        for(int i=0;i<randoms.length;i++){
            System.out.println(randoms[i]);

        }
    }


 
    public static void main(String[] args) {
        Quiz2 q2=new Quiz2();
        q2.setArray();//초기화
        q2.randomsPrintf();
        q2.total();
       

        
    }
    
}
