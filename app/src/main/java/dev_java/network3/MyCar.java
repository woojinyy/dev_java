package dev_java.network3;

public abstract class MyCar {
    public abstract void display();
    private int wheelNum = 0;

    public MyCar(){//디폴트 생성자
        System.out.println("MyCar() 디폴트 호출");
    } 
    public MyCar(int wheelNum){//파라미터가 int인 생성자
        System.out.println("MyCar(int) 파라미터가 int인 생성자 호출");
        this.wheelNum=wheelNum;
        //전역변수로 바뀐다.
    }

    
    public void go(){
        System.out.println("나는 앞으로 간다.");
    }//추상클래스는 일반메소드와추상메소드를 가질 수 있다 디폴트생성자 가질 수 있다.
    
}
