package dev_java.design;

public class Quack implements QuackBehavior{
 //Q. 꽥꽥?? ......?? 언제 누가 어디에서 결정할 수 있나??
    //A. 해당 기능이 요청 될 때 구현하고자 하는 객체가 무엇인가에 따라(Duck myDuck = new WoodDuck();  )
    //생성부에 따라 (new RubberDuck(); , new MallardDuck(); )
    @Override
    public void quack() {
        System.out.println("꼬ㅒ꼬ㅒ꼬ㅒ꼬ㅒ꼬ㅒ꼬ㅒ꽥");
    }
}
