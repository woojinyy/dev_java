package dev_java.ch02;


public class Memberlnit {
    int i;//클래스에 선언된 전역변수 i
    int hap; //hap
    //디폴트 생성자라고 부른다-디폴트 생성자는 파라미터를 결정해줄 필요 없으니 생략하면
    //JVM이 대신 생성해 주어 전변들을 초기화한다
    public Memberlnit(){
        System.out.println("디폴트 생성자 호출 성공"+i+hap);//00

    }
    
    public Memberlnit(int i,int hap){//변수 이름이 똑같네?? 뭐가 뭐야??
        //this.i 하면 전역변수
        System.out.println("파라미터가 두개인 생성자 호출 성공"+i+hap);
        this.i=i;
        this.hap=hap;

 
       }
       public static void main(String[] args) {
        Memberlnit mi= new Memberlnit();//9번 생성자 호출
        //메소드 오버로딩 (메소드 파라미터 갯수 타입 다를때 중복선언 가능하다) 메커니즘을 따른다 이름은 씨발 중요한게 아니었어
        Memberlnit mi2=new Memberlnit(1,0);
       }
}
