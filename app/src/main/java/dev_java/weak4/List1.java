package dev_java.weak4;
//자바에서 제공하는 자료구조는 java.util폴더에 있다
import java.util.List;
import java.util.Vector;

public class List1 {
    public static void main(String[] args) {
        //List<String> nameList = new List<>();
        //List는 구현체클래스가 아니다 
        //생성부에 인터페이스가 오면 에러다 인터페이스를 오버라이딩한 vector, arraylist 쓸 수 있다
        List<String> nameList = new Vector<>();
        System.out.println(nameList.size());//0
       
        boolean isOk= nameList.add("이순신");
        System.out.println(nameList.size());// 이순신이 추가됐으니 1칸 추가
        System.out.println(nameList.get(0));//인덱스0의 값은 이순신
        System.out.println(isOk);//불리언(참거짓) true
    }
}
