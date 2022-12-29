package dev_java.design;

public class MallardDuck extends Duck{		
	public MallardDuck() {	//인스턴스화를 생성자 안에서 = 게으른 인스턴스화(ApplicationContext) <-> 이른 인스턴스화 (BeanFactory)  -> 스프링,전자정부프레임워크 에서 핵심
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();//날 수 있다
	}	
	public void display(){	
		System.out.println("저는 물오리입니다.");
	}	
}		