package dev_java.waek3.Lecture1216;

import java.util.Vector;

public class Vector3 {
    public static void main(String[] args) {
        
    Vector<Integer> v = new Vector<>(); //객체는 생성되었으나 방은 없다
    System.out.println(v.size());//0  방이없기때문에
    System.out.println(v.isEmpty());//t  //담을 방이 없는데 당연히 비었지 
    boolean add=v.add( 11);
    System.out.println(v.size());
    boolean add2=v.add( 100);
    System.out.println(v.size());
    boolean isExist=v.add(1);// add해야 방이 생긴다> 0번째방에  2를 넣는다
    System.out.println(v.size());
    System.out.println(v.get(0));//1   0번째에 값을 가져온다 
    System.out.println(isExist);//t  값이 존재하니?? 예 >t
    System.out.println(v.isEmpty());//f 방이 비었니? 아니오 >f
    System.out.println(v.contains(10));//t 0번째방에 값이 contains값과 같니? 예 > t
    System.out.println(v.contains(11));//t 1번째방에 값이 포함되어있니? 아니오 >f
    v.add(1, 2);//f  1번방에 2를 넣는다
    System.out.println(v.contains(2));//f>t 2번방에 값이 포함되어 있니? 예 >t
    System.out.println(v.remove(1));//1번방의 값을 제거
    boolean isOk=v.remove(new Integer(1));
    System.out.println(v.size());//1
    }
}
