package dev_java.design;

public class FlyWithWings implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("날 수 있습니다.");
    }
    
}
