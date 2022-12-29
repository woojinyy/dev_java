package dev_java.weak4;

public class DeptVOMain {
    public static void main(String[] args) {
        //DeptVO dVo= new DeptVO();// 롬복을 쓰면 디폴트 생성자를 쓸 수 없다
        DeptVO dVo=DeptVO.builder().dname("총무부").build();
        DeptVO dVo2=DeptVO.builder().deptno(20).loc("인천").dname("총무부").build();
       // System.out.println(dVo.getDeptno()+","+dVo.getDname()+dVo.getLoc());
    }
}
