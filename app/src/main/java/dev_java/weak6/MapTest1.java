package dev_java.weak6;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

//vector +map
//헤어지면 안돼 친하게 지내 두손 꽉잡아
class S1{
int age=10;
}
class S2{
    String animal="dmddo";
    int leg=4;
}
class S3{
    String str="";
    int i=1;
    int j=2;
}
public class MapTest1 {
    List<Map<String,Object>> list = null;//선언
    public static void main(String[] args) {
        S1 s1=new S1();
        System.out.println(s1.age+"살");
        //s1을 맵에 다 넣어보자 map을 인스턴스화 하려면 구현체클래스 필요해 hashmap(sigle),hashtable(multi)
        Map<String,Object> map1=new HashMap<>();
        map1.put("s1",s1);
        S1 s2=(S1)map1.get("s1");
        System.out.println(s2.age);
        Map<String,String> map11=new Hashtable<>();
        
        Map<String,Object> map2=new Hashtable<>();
        //s1을 담으려면  map1이 필요? map11이 필요?
    S2 s3= new S2();
    map2.put("s2", s3);
    S2 s4=(S2)map2.get("s2");
    if(s4.animal instanceof String){
        System.out.println("문자열 입니다.");
                //instanceof :타입체크한다
    }
    //Deprecated 하위버전을 위해 남겨놓았다 킹치만 이제 지원 안한다 
    if(new Integer(s4.leg) instanceof Integer){
        System.out.println("정수형입니다.");
    }
    }
}
