package dev_java.waek3.table;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class DeptTable2 extends JFrame {// 상속 extends
    // DeptTabl1 is a JFrame
    // 선언부
    String header[] = { "부서번호", "부서명", "지역" };
    String datas[][] = new String[1][3];
    DefaultTableModel dtm_dept = new DefaultTableModel(datas, header);// 생성자 호출
  
    // 생성자
    public DeptTable2() {
        initDisplay();
    }
    public DeptTable2(String title){

    }

    public DeptTable2(int i) {
    }
    // 화면그리기
    public void initDisplay() {
        this.setSize(500, 400);
        this.setVisible(true);
        this.setTitle("부서관리시스템Ver1.0");
    }

    // 메인메소드
    public static void main(String[] args) {
        new DeptTable2();
    }
}
