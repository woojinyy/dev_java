package dev_java.weak5;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*						
 * 상황에 따라 분리된 스레드로 백그라운드 작업을 해야 하는 경우도 있다.						
 * JVM안의 가비지 컬렉션과 같은 작업이 대표적이다.						
 * 이런 백그라운드 작업이 일반 스레드로 설정되어 있다면 전원이 종료되거나 사용자가 강제 종료하지 않는 한						
 * 애플리케이션은 영원히 정지 하지 않을 것이다.						
 * 						
 */		
//클래스 이름 : DeamonTHreadTest.java
//-> 컴파일 하면 DeamonTHreadTest.Class	,DeamonTHreadTest$1.Class(익명클래스)
//Node.js ES5,6,7arrow function, 람다식, 최신문법

import javax.swing.JButton;
public class DeamonThreadTest {						//익명클래스 처리해서 implements 필요 없다
		JButton jbtn = new JButton("전송");
        public DeamonThreadTest(){
         //   jbtn.addActionListener(this);//this는 이벤트처리를 담당하는 핸들러클래스를 나타낸다
            jbtn.addActionListener(new ActionsListener(){
                public void actionPerformed(ActionEvent ae){
                    System.out.println("전송버튼킄ㄹ릭");
                }// end of ationPerformed
            });
        }
	public static void main(String[] args) {					
		Thread th = new Thread() {			//Override 쓰레드의 추상 메소드 직접 정의할 수 있다. -> 익명클래스다	
			public void run() {			
				try {		
					Thread.sleep(5000);	
					System.out.println("MyThread 종료");	
				} catch (InterruptedException e) {		
						
				}		
			}			
		};				
		//데몬 스레드로 설정함.				
		//아래와 같이 데몬스레드를 설정하면 내부의 모든 스레드가 종료되지 않아도 어플리케이션이 종료된다.		
		//setDeamon을 설정하여 옵션을 true로 주면 thread와 상관 없이 앱을 강제 종료 시킨다.
		//프로그램에서 처리하는 것과 상관 없이 별개로 동작 해야 하는 것들이 있다면 
		//Deamon메소드를 호출하지 말거나 추가했다면 false로 설정해야 한다.		
		th.setDaemon(false);//false로 하면 MyThread 종료가 출력된다. 이문장이 없으면 false와 결과같음.				
		th.start();				
		System.out.println("main() 종료");				
	}///////////////end of main					
}						