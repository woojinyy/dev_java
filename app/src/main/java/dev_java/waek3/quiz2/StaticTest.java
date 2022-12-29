package dev_java.waek3.quiz2;

class S1{
    int j;
    static int i;//전역변수성격 인스턴스화 없이 사용 가능 복제본을 만들지 않을 때 
    static void m(){
    }    
    }
class S2{
    void n(){//전역변수라 리턴값 상관 없어 void 쓴다
S1.i=500;//타입 이름 인스턴스변수 아니야
    }
}

public class StaticTest {//스테틱이 묻은 변수는 인스턴스화 없이 사용이 가능하다
    public static void main(String[] args) {
        S1.i=10;//스테틱이 있어서 인스턴스화 없이 사용 가능 S1 타입을 붙여서 쓴다
        System.out.println(S1.i);
        //Q. 인스턴스화 하면 안됨??
        S1 s1= new S1();
        s1.i=100; //A. 가능은한데 하지말라면 하지마 이새끼야
        System.out.println("스테틱은 복제본 못만들어 :"+S1.i);// 스테틱은 복제본을 못만들어 똑같은 값이 출력된다
        System.out.println("스테틱은 인스턴스화 필요 없어 근데 한번 써봤어 :"+s1.i);
        S2 s2= new S2();
        s2.n();//메소드 호출 
        System.out.println("n()메서드 호 출 후 : "+S1.i);
    }
}
