package dev_java.ch02;

public class Array {//3자리수-중복X 타입 부서번호,사원번호,

    public static void main(String[] args) {
     for(int i=0;i<3 ;i++){//for (int i:deptnos) 전체 호출 시
        int deptnos[];//선언만했다 
        deptnos = new int[3];//초기화
        System.out.println(deptnos[i]);//System.out.println(i);
     }
        for(int j=0;j<3;j++){
        int deptnos1[] =new int[3];
System.out.println(deptnos1[j]);
        }
}
}


