package dev_java.ch01;

public class DeptVOMain {
    public static void main(String[] args) {
        DeptVO deptVO= new DeptVO();//선언
        deptVO.deptno=10;// 선언먼저
        deptVO.dname="개발1팀";
        System.out.println(deptVO.deptno);
        System.out.println(deptVO.dname);
        deptVO = new DeptVO();//타입은 같아(고객정보) 타입선언 안한다.
        //객체 생성이다 
        deptVO.deptno=30;
        System.out.println(deptVO.deptno);
        System.out.println(deptVO.dname);
        System.out.println(deptVO.local);
    }
}
