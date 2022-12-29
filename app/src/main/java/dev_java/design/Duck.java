package dev_java.design;

//추상클래스
//단독으로 인스턴스화 할 수 없다 반드시 구현체 클래스 있어야 한다 메소드 오버라이딩
//인터페이스가 추상클래스 보다 더 추상적이다 -생성자 일반메소드도 갖고있다.
//생성자는 전역변수의 디폴트값을 결정 할 수 있다.
public abstract class Duck {		
        FlyBehavior flyBehavior;	//인터페이스 -날수있다, 날지못한다
        QuackBehavior quackBehavior;	//인터페이스 -무음MuteQuack, 유음 Squeak,꽥꽥 Quack
        public Duck(){}	//생성자
        public abstract void display();	
        public void performFly(){	
            //FlyWithWings.java, FlyNoWay.java //구현체클래스 이름을 임의로 정함
            flyBehavior.fly(); //flyBehavior에서 fly 정의하고 있다  =추상메소드이다 -> overriding 필요하다 ->구현체 클래스가 필요하다
        }	
        public void performQuack(){	
            quackBehavior.quack();
        }	
        public void swimming(){	
            System.out.println("모든 오리는 물위에 뜬다");
        }   	
    }		