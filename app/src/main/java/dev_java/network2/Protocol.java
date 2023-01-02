package dev_java.network2;

public class Protocol {
    
    public static final int TALK_IN = 100;
    public static final int MESSAGE = 200;
    public static final int WHIS = 300;//1:1 대화
    public static final int CHANGE = 400;
    public static final int TALK_OUT = 500;
    public static final String separator="#";
}
/*
 * final이  클래스 앞에 오면 상속을 못함
 *             메소드 앞에 오면 메소드 오버라이딩 못함
 *             변수앞에 오면 상수임
 */