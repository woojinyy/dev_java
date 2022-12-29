package dev_java.design;
//단독으로 인스턴스화 못한다 구현체 클래스가 반드시 있어야 한다
//QuackBehavior qb =new MuteQuack();가능
//QuackBehavior qb =new Quack();         가능
//QuackBehavior qb =new Squeak();       가능
public interface QuackBehavior {
    /*/
    int i;
    final int j;
    static int k;
    static final int y;     변수 선언 안된다
    */

    //public QuackBehavior(){} 생성자 안된다
    
    //abstract 생략 가능 인터페이스는 오직 추상만 가능하니까
    //추상클래스는 생략 못한다
    public abstract void quack();//추상메소드
}
