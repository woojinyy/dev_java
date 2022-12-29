package dev_java.waek3;

public class Main_2 {
    int i = 1;
    boolean isOk[] =null;// [false,false,false]
    public Main_2(){//디폴트 생성자는 생략 가능
        //그러나 isOk 배열의 생성을 위해 getisOk()메소드를 경유하도록
        //해야지 NullPointerException 을 피할 수 있다.
        System.out.println("Main_2()디폴트 생성자 호출 성공");
        getisOk();// 생성자 경유
    }
    /*
    선언과 동시에 인스턴스화를 하지 않는 경우를 게으른 인스턴스화라고 한다
    선언과 생성을 동시에 하지 않고 메소도를 통해서 객체 주입을 받을 수 있다
    이렬경우 메소드 안에서 if문을 통해 널체크를 할 수 있어 싱글톤 패턴으로 객체를
    주입받을 수 있다 따라서 현업에서 선호하는 객체 주입 방법 중 하나이다.
     */
 boolean [] getisOk(){//호출되어야 length가 결정된다
    if(isOk==null){
        isOk= new boolean[] {true,false,true};
    }
    
    return isOk;//초기화
 }
    public static void main(String[] args) {

    }

}
