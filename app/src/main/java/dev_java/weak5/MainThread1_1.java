package dev_java.weak5;


			
/*			
 * main메소드 호출은 JVM에 의해 호출된다. 			
 * JVM은 main스레드를 생성하여 main메소드를 호출한 것이다.			
 * 따라서 프로그램을 실행할 때 main메소드가 실행되었다는 것은 main스레드가 			
 * 수행되는 것이다.			
 * 그리고 main안에서 사용자가 만든 새로운 스레드를 실행시켰다면 			
 * 두 개의 스레드(main 스레드와 사용자 스레드)가 작동하고 있다는 것을 의미한다.			
 * 			
 * 아래 결과는 예측 불허(실행할 때마다 다를 수 있다.)			
 * 			
 */			
public class MainThread1_1 {			//나는 Thread 클래스가 아니다 Q. 왜? A. implements 안했다.
			//단 MainThread 자체는 갖고있다.
            //JVM동작순서 19 -> 20->21->22 인스화만 했다 start()메소드 호출x run 호출 x ->25 implements라서 필요 ->26 start호출->run호출 but즉시 실행 x 대기 순서따져야해 -> 50 51->52> 54> 55> 56> 58 >59 >60 
	public static void main(String[] args) {		
		System.out.println("====================================");	
        System.out.println("main start");        			
        Runnable r = new MyRunnableOne();//좌변에는 인터페이스  우변에는 구현체 클래스 구현체클래스 안에는 override가 있어야해 ovrride의 이름은run run 메소드는 추상메소드 MyRunnableOne이 구현했다. -> 다형성을 누린다= 선언부와 생성부가 다르다
        //코드를 조금만 수정하고 유지보수 가능하니까 많이 손대면 의존관계 때문에 다른에러 유발
                                                                                    //                  static에서this쓰면 에러난다
        Thread myThread = new Thread(r);			//Thread myThread = new Thread(this); Q. this 넌 누구니?? A. MainThread1_1 난 스레드가 아닙니다 상속x 인터페이스 implements X  r은 run메소드를 오버라이딩 하고있다.Thread 상속X 인터페이스 implements O ->Overriding
        myThread.start();			// 자체가 thread 
       /*/ try {// Thread 클래스가 제공하고있다. 스레드 구현하자 스케줄을 짤 수 있다.
            myThread.sleep(5000);//슬립은 반드시 try-catch안에 들어와있어야해
            myThread.join(); //내 뒤에 다 기다려   내코가 석자야 
            myThread.yield();//양보 너 먼저해 
            
        } catch (Exception e) {
            // TODO: handle exception
        }*/
        Thread himThread =new MyRunnableTwo();
        himThread.start();
        //상속으로 처리하든 인터페이스로 처리하든 그에따른 우선순위는 없다 선착순 1명 
		System.out.println("main end");	
	}		
			
}			
//Thread가 되는 방법 두가지 1.상속 2. implements 1,2 둘다  run Method를 가질 수 있다. 재정의 할 수 있다. -> 그 안에서(=run안에서) 실행문을 처리하면 안전하다
			class MyRunnableTwo extends Thread{//상속받았으니까 
            @Override//쓸수있어
            public void run(){
                System.out.println("MyRunnableTwo run 호출");
            }
            }
class MyRunnableOne implements Runnable{			
    public void run(){			
        System.out.println("run메소드 호출 성공");			
        first();			
    }			
    public void first(){			
        System.out.println("first메소드 호출 성공");			
        second();			
    }			
    public void second(){			
        System.out.println("second메소드 호출 성공");			
        System.out.println("====================================");			
    }			
}			
/*
 * 클래스를 상속받으면 클래스간 결합도가 높아진다. -> 재사용성이 떨어진다.-> 오작동의 원인이 된다.->EX) 새가 난다 -> 비행기가 난다 재사용성이 떨어진다 
 * 기능적인 부분을 결합도를 낮추면서 테스트도 용이하고 오작동도 방지되는 방법
 * 인터페이스 중심의 코딩을 전개하면된다 재사용성을 높이는데 Overriding해라 뒤지기 싫으면
 */