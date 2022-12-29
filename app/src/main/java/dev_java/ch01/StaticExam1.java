package dev_java.ch01;
//static은 변수앞에 method앞에 올 수 있다.
//static이 있으며 정적변수, 정적메소드라 한다.
//instance화 없이 어디서나 호출할 수 있다
//non-static에서 호출할 수 있다?없다?
public class StaticExam1 {
    int  i=1;//전역변수는 초기화를 생략할 수 있다. 그러면 디폴트=0 
    static int  j;
 void methodA(){
        System.out.println("i="+i);
        System.out.println("j="+j);

    }
    public static void main (String[] args) {
 
 
    
    

}
}