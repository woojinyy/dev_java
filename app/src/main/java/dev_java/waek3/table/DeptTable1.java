package dev_java.waek3.table;
//이른 인스화 게으른 인스화

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//어떤 클래스를 상속 받을 때에는 extends예약어를 사용
//부모클래스가 가진 변수와 메소드도 사용 가능 하다 => 상속받은 클래스가 더 많은 기능을 가질 수 있다.니건 내거 내건 내거
//A is a B관계이면 상속처리한다. -> 포함관계 유의
//소나타는 자동차(O) 
//자동차는 소나타 (X) 
import javax.swing.table.DefaultTableModel;

public class DeptTable1 extends JFrame{// 상속 extends
    //DeptTabl1 is a JFrame
    //선언부
    String header[]={"부서번호","부서명","지역"};
    String datas[][]=new String[1][3];
    
    DefaultTableModel dtm_dept = new DefaultTableModel(datas, header);//생성자 호출 
    //this는 사용되는 클래스 영역에서 선언된 클래스를 가리킨다
    //그러면 여기서는 DeptTable1타입인것
    //그런데 DefaultTableModel은 자바에서 제공되는 클래스임 생성자가 정해져있다.
    //생성자는 메서드 오버 로딩 규칙을 따름 파라미터 개수 타입이 달라야함
    //제공되는 생성자에 this는 없음 -> 컴파일 에러
    JTable jtb_dept= new JTable(dtm_dept);
    JScrollPane jsp_dept= new JScrollPane(jtb_dept
    ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JPanel jpanel_north=new JPanel();
    JButton jbtn_ins=new JButton("입력");
    JButton jbtn_upd=new JButton("수정");
    JButton jbtn_del=new JButton("삭제");
    JButton jbtn_all=new JButton("전체보기");

    //생성자
    public DeptTable1(){
    initDisplay();
    }
    //화면그리기
    public void initDisplay(){
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jpanel_north.setLayout(new FlowLayout(FlowLayout.RIGHT));
      jpanel_north.add("North",jbtn_ins);
      jbtn_ins.setBackground(new Color(158,9,9));
      jbtn_ins.setForeground(Color.WHITE);

      jpanel_north.add("North",jbtn_upd);
      jbtn_upd.setBackground(new Color(158,9,9));
      jbtn_upd.setForeground(Color.WHITE);
      jpanel_north.add("North",jbtn_del);
      jbtn_del.setBackground(new Color(158,9,9));
      jbtn_del.setForeground(Color.WHITE);
      jpanel_north.add("North",jbtn_all);
      jbtn_all.setBackground(new Color(158,9,9));
      jbtn_all.setForeground(Color.WHITE);
      this.add("North",jpanel_north);
      this.add("Center",jsp_dept);
      this.setSize(500,400);
      this.setVisible(true);
      this.setTitle("부서관리시스템Ver1.0");
  
    }
    //메인메소드
    public static void main(String[] args) {
        new DeptTable1();
    }
}
