package dev_java.ch01;
//class 에는 여러개의 변수를 가질 수 있다.
/*
 * 부서번호          부서명            지역
 * 10                  개발1팀          부산
 * 20                 개발2팀        제주도
 * 30                  운영팀            서울
 * ---------------------------인스턴스화를 세번 해야해
 * 변수는 한번에 하나만 변수9개 선언할거야?
 * 관계가 있는 
 */
public class DeptVO {
    int deptno; //선언만 초기값 갖고있다 0
    String dname;//참조형 타입 초기값 null
    String local;//참조형 타입 초기값 null
}
