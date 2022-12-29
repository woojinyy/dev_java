package dev_java.weak5;

class StopThread implements Runnable {						
	boolean stopped = false;					
						
						
	@Override					
	public void run() {					
		while(!stopped) {				
			System.out.println("Thread is alive....");			//
			try {			
				Thread.sleep(500);		//0.5초 마다 Thread is alive 또 출력
			} catch (InterruptedException e) {			
				e.printStackTrace();		
			}			
		}				
		System.out.println("Thread is deaded");				//9~16구간 중 12번에서 멈춰있을 때 다른 스레드가 인터셉트 가능하다 
	}		//end of while 0.5초동안에 일어난다			
	public void stop() {					
		stopped = true;				
	}					
}						
						
						
			
						
public class StopThreadTest {			
    //29 -31-32	-33-34-35(스레드 객체 생성- 파라미터36번주소 넘김 -36-8(call back 호출(스레드 대기자방에서 우선순위 따진다.)))
	public static void main(String[] args) {					
		StopThreadTest stt = new StopThreadTest();				
		stt.process();			//메소드를 관리하는 영역stack	
        System.out.println("main end");//0.5초 멈춰있는 동안 스레드 우선순위 인터셉트 당해 어플리케이션 죽는다 -메인스레드 회수 by JVM
	}					
	public void process() {					
		StopThread st = new StopThread();//	지역변수로 객체 생성-여기에서만 살고죽음
		Thread th = new Thread(st);			//스레드 생성(파라미터넘겨)	
		th.start();				//run호출
		try {				
			Thread.sleep(1000);			
		} catch (InterruptedException e) {				
			e.printStackTrace();			
		}				
		st.stop();				
	}					
}						