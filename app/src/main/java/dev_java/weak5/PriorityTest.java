package dev_java.weak5;

public class PriorityTest extends Thread {
    //Field
    private String threadName; //스래드 이름 기억용
    //Constructor
    public PriorityTest(String threadName) {
    this.threadName = threadName;
    }
    //Method
    @Override
    public void run() {
    //스래드 이름 출력 3번 반복
    for(int i = 0; i < 3; i++) {//스레드 한번당 3번호출
    System.out.println(threadName + "가 구동됨.");
    }
}
public static void main(String[] args) {
    // 우선 순위 테스트용
    //나는 Thread를 상속 받았다 = 내 생성자가 호출 되면 그보다 먼저 THread생성자가 호출 된다.
    //상속관계 있을떄 implements할 때만 메소드 overriding 
    //overriding은 서로 상속관계있을 때, implements있을때 중복을 따진다 
    //선언부=리턴타입은 손대지 않는다.파라미터 손대지 않는다
    //기준은 부모클래스  어떤메소드를 갖고있는지 알고 있어야 비교가 가능하다 맞지?
    //뭐가 먼저 호출된다?  상위클래스의 생성자가 먼저 호출된다.
    //클래스가 동시에 Thread 일 수도 있다
    //파라미터에 String
    //overloading은 관계 없어
    Thread t1 = new PriorityTest("제일 높은 스래드"); 
    Thread t2 = new PriorityTest("보통 스래드");
    Thread t3 = new PriorityTest("제일 낮은 스래드");
    t1.setPriority(Thread.MAX_PRIORITY); //10 (aka 가중치 /절대적X )
    t2.setPriority(Thread.NORM_PRIORITY); //5
    t3.setPriority(Thread.MIN_PRIORITY); //1
    t1.start();
    t2.start();
    t3.start();
    }
    }