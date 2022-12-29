package dev_java.design;

public class WoodDuck extends Duck{
    public WoodDuck(){
        //설계한 객체가 어떤 특성,활동이 결정됨 - 생성자
       quackBehavior = new MuteQuack();
       flyBehavior = new FlyNoWay();//날 수 없다
    }
    @Override
    public void display() {
       System.out.println("나는 나무오리 입니다.");
    }
 }