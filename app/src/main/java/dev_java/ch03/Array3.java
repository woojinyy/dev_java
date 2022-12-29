package dev_java.ch03;

import java.util.Arrays;

public class Array3 {//배열복사
    public static void main(String[] args) {
        int i[] = {1,2,3};
        String s1=null;
        int j[]; //선언만 했다 주소번지를 갖느다
        j=i;//선언만했는데 치환이 될까?
        i[0]=5;//값을 변경해보자
        //String s1="ㅎㅇ";
        String s2=s1;
System.out.println(i);//Q.주소번지가 나올까?A 주소값이 나오겠지 
System.out.println(j);//주소번지가 나올까?
System.out.println(Arrays.toString(i));//주소번지가 나올까?
System.out.println(Arrays.toString(j));//주소번지가 나올까?
System.out.println(s2);//Q. 문자열이 나올까? 주소가 나올까?A.주소나오겠지
//에러 String은 참조형이나 예외적으로 값이 출력된다.

    }
}
