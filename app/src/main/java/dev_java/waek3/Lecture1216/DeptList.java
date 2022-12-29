package dev_java.waek3.Lecture1216;

import java.util.Scanner;
import java.util.Vector;

public class DeptList {
    Vector<DeptVo> vdept = new Vector<>();// 담을 List
    // 부서등록
    // 성공하면 1 실패하면 0

    int deptinesert(DeptVo pdVO) {
        int result = 2;
        boolean isOk = vdept.add(pdVO);
        result = isOk ? 1 : 0;
        return result;
    }

    // 부서수정
    int deptUpdate(DeptVo pdVO) {// 부서명, 지역만 수정 가능 번호는 불가
        int result = -1;
        //vdept.set(1,"제주");
        return result;
    }

    // 부서삭제
    int deptDelete(int deptno) {
        int result = -1;
        
        return result;
    }

    // 부서정보상세

    int deptDetail(DeptVo pdVO) {

        int result = -1;
        return result;
    }

    // 부서 전체 조회
    void DeptList() {
        DeptVo dept = new DeptVo(10, "개발부", "서울");
        vdept.add(dept);
        dept = new DeptVo(20, "인사부", "세종");
        vdept.add(dept);
        dept = new DeptVo(30, "기재부", "인천");
        vdept.add(dept);

        System.out.println(vdept.get(0));
        System.out.println(vdept.get(1));
        System.out.println(vdept.get(2));

    }

    // 메인
    public static void main(String[] args) {
        DeptList dlist = new DeptList();
        dlist.DeptList();
        dlist.deptDelete(1);
        System.out.println(dlist.deptDelete(1));

    }
}
