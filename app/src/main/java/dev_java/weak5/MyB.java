package dev_java.weak5;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
// l메소드가 v메소드보다 더 넓다 
public class MyB {
    //메소드의 파라미터로 인터페이스를 사용하는 경우
    void l(List<String>myNames){
        System.out.println("===========[List<String>]=========");
        for(String s:myNames){
            System.out.println(s);
        }
    }
    //메소드의 파라미터로 구현체 클래스를 사용하는 경우
    void v(Vector<String>myNames){
        System.out.println("===========[Vector<String>]=======");
        for(String s:myNames){
            System.out.println(s);
    }
}
    public static void main(String[] args) {
        MyB myB = new MyB();
        List<String> nickNames3 = new Vector<>();
        nickNames3.add("사자");
        nickNames3.add("호랑이");
        nickNames3.add("표범");
        ArrayList<String> nickNames = new ArrayList<>();
        nickNames.add("토마토");//add메소드 첫번째 방
        nickNames.add("키위");//두번째 방
        nickNames.add("사과");//세번째 방
        Vector<String> nickNames2= new Vector<>();
        nickNames2.add("바나나");
        nickNames2.add("알러지");
        nickNames2.add("원숭이");
        myB.l(nickNames);
        //
        myB.l(nickNames3);//8번
      //  myB.v(nickNames);
        myB.l(nickNames2);
        myB.v(nickNames2);
    }
}
