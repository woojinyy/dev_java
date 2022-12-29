package dev_java.waek3.quiz2;

//메소드 꺼내기 
//리턴타입을 결정해본다 void, int 
//파라미터의 개수를 결정한다
//파라미터의 타입을 결정한다
//출력하기 어디에??
class Rectagle2 {
    // 메소드 이름을 같은 이름으로 하였다. 이럴경우 메소드 오버로딩을 따져야함
    void area(int w, int h) {// 오버로딩 규칙 파라미터의 개수, 타입이 달라야한다
        int area = w * h;
        System.out.println("면적" + area);
    }
    int area(int w, int h, int result) {
        result = w * h;
        return result;
    }
    long area(long w, long h) {
        return w * h;
    }
}
public class Rectangle2Main {

    public static void main(String[] args) {
        Rectagle2 r = new Rectagle2();
        long result = 0;

        r.area(2, 3);// 값에의한 호출 call by value
        System.out.println(r.area(2L, 4L));
        r.area(5, 4, 0);
        System.out.println("3 : " + r.area(5, 4, 0));

    }

}