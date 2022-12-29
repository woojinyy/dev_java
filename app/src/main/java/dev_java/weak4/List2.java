package dev_java.weak4;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class List2 {
    public static void main(String[] args) {
        // 자료구조를 지원하는 클래스들은 오브젝트의 존재유무 체크
        // 포함여부
        // 비어있는지 혹은 채워져 있는지 확인해주는 API 를 제공한다
        List<String> fruitList = new Vector<>();
        fruitList.add("사과");
        fruitList.add("바나나");
        boolean isExist = fruitList.contains("토마토");// false
        System.out.println(isExist);// false
        isExist = fruitList.contains("바나나");// true
        System.out.println(isExist);// true
        if (isExist) {
            System.out.println("들어있다!!");
        } else {
            System.out.println("없다!!!!!!!");
        }
        boolean isEmpty = fruitList.isEmpty();
        System.out.println(isEmpty);// false
        // Vector 나 ArrayList는 오브젝트를 추가,꺼내는 기능제공
        // Iterator는 그 안에 오브젝트가 존재유무에 관심
        Iterator<String> iter = fruitList.iterator();
        while (iter.hasNext()) {
            String fname = iter.next();
            System.out.println(fname);
        }
        // Iterator iter2 = fruitList.iterator();
        // while(iter2.hasNext()){
        // 다이아몬드연산자( < > ) 에 의미 타입을 명시적으로 작성해야한다
        // String fname=(String)iter2.next();//제네릭타입을 지정하지 않아서 에러
        // System.out.println(fname);
        // }
        // Vector의 제네릭 타입이 여기서는 String이라 에러가난다
        // Iterator<Object> iter3Iterator=fruitList.iterator();
        // while(iter3Iterator.hasNext()){
        // String fname=iter3.next();
        // System.out.println(fname);
        Iterator<String> iter4 = fruitList.iterator();
    }

}
