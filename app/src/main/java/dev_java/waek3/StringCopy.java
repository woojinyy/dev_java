package dev_java.waek3;

public class StringCopy {
    public static void main(String[] args) {
        String str="hello";
        String str1="hello"; 
        System.out.println(str==str1);//주소번지가 같니?true
        System.out.println(str.equals(str1));//주소번지가 가리키는 값이 같니?true
        String str2=new String("hello");
        String str3=new String("hello"); 
        System.out.println(str2==str3);//주소번지가 같니? false 새로 인스화라 주소가 다르다
        System.out.println(str2.equals(str3));//주소번지가 가리키는 값이 같니?true
    }
}
