package dev_java.weak5;
class Sup{
    Sup(){//부모 디폴트 생성자 선언
System.out.println("아빠디폴트 호출");
    }
    public void m(){
        System.out.println("Sup m()호출");
    }
}
class Sub extends Sup{
    Sub(){
    this.m();//super =상위클래스 
    }
@Override
public void m(){
    System.out.println("Sub m ()호출");
}
}

public class SupNsubMain {
    public static void main(String[] args) {
        Sup sup= new Sup();//인스턴스화
       // sup.m();//메소드 호출
        Sub sub= new Sub();//인스턴스화
      //  sub.m();//메소드 호출

        //선언부 -상위클래스, 인터페이스 = 생성부-하위클래스
    Sup sup2=new Sub();//부모의 메소드는 shadow method
      //  sup2.m();
//Q. 선언부는 Sup Cls 생성부에는 자손Cls 같은메소드가 두개  뭐가 출력?
//생성부 이름으로 생성된다.
/*
 * sup를 대입하는 경우에는 실제 생성된 객체도 Super타입
 * 따라서 강제 형젠환을 하더라도 그래서 문법적인 문제는 해겨을 했어도 실제로 가리키는
 * 객체는 사우이객체이므로 에러 발생
 * 그러나 sup2로 하게되면 실제 생성된 객체가 자손인 Sub타입이니까
 * 타입은 달라서 강제형전환 해야 되지만 실제 가리키는 객체가 자손타입이므로
 * 에러없이 실행가능
 */
//sub = (Sub)sup;//강제 형전환 (받아주는타입) 원본 sup의 타입이 Sup 강제 형전환 타입은 Sub
sub=(Sub)sup2;//sup2의 타입이 Sub으로 강제 형전환

        sub.m();//sub = new Sup();
        //ClassCastException
    }
    
}//인스턴스화 -> 생성자 호출
