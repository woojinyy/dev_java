package dev_java.weak4.Exam1221;
/*
 * 접근제한자가 있고 없고는 영향이 없다
 * 리턴타입이 있고 없고는 영향이 없다
 * 예외를 던지고 던지지않고는 영향이 없다
 * 파라미터의 변수이름이 다른것은 영향이 없다
 * 메소드오버라이딩-문제와 상관없음
 */
public class Exam1 {
    public void methodA() {}
    public void methodA(int a){}
    
        //public int methodA() { 파라미터의 개수 차이가 없기 때문에 중복선언이다
            //return 1;
        //}
        //public void methodA(int a) throws Exception{} 던지고 던지지 않고는 영향이 없다
            public void methodA(double a ,double b){}
            public void methodA(String name, double d){}
        
    }

