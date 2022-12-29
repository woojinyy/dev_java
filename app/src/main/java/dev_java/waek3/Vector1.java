/*package dev_java.waek3;
import java.util.Vector;

public class Vector1 {
    public static void main(String[] args) {
        Vector v= new Vector();
        Vector<String> v2 = new Vector<>();// <wrapper클래스>쓰세요
        v2.add("안녕");//v.get(0)
        v2.add("2");//v.get(0)
        Vector<Integer> v3 = new Vector<>();
        Vector<DeptVO> v4 =new Vector<>();
        v.add(1);//v.get(1)
        v.add("안녕");//v.get(1)
        
        //v.add(new Integer(1));// 그냥 1 써 오토박싱 해주니까 이런거 쓰지마
        v.add("ㅎㅇ");
        System.out.println(v.size());//2
        System.out.println(v.get(0));//1    
        System.out.println(v.get(1));   //ㅎㅇ
       
        
        String insa2= v2.get(0);
        System.out.println(insa2);
        if(v.get(1)instanceof String){
            System.out.println("정수형");
        }
        if(v.get(1)instanceof String){
            System.out.println("넌 문자열이야");

        }
    }
}
*/