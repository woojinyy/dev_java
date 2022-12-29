package dev_java.waek3.table;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//ActionListener - 인터페이스 단독으로 인스턴스화가 불가능함 구현체 클래스가 필요하다
//추상메소드를 선언하고 있다. 생성자도 가질 수 없다.
//ActionListener al=new DeptTable3(); 선언부와 생성부가 다를 수 있다= 이럴 때에만 다형성이 가능하다
//선언부와 생성부가 다르다 -> 동일한 메소드를 호출 했는데 다른 기능이 처리 되었다???(다형성의 컨셉)
//추상클래스도 구현체 클래스가 필요하다 -this
//Duck myDuck = new WoodDuck(); myDuck.fly() 오리는 추상클래스 생성부에 따라 특징이 달라진다. 날수X
//Duck herDuck = new RubberDuck(); herDuck.fly()날수 X
//Duck himDuck = new MallardDuck(); himDuck.fly()날수 O
import java.util.Vector;

public class DeptTable3 extends JFrame implements ActionListener {// 상속 extends
    // DeptTabl1 is a JFrame
    // 선언부
    String header[] = { "부서번호", "부서명", "지역" };
    String datas[][] = new String[0][3];
    String[][] depts = { { "10", "개발", "서울" }, { "20", "인사", "인천" }, { "30", "총무", "부산" }, };
    DefaultTableModel dtm_dept = new DefaultTableModel(datas, header);
    JTable jtb_dept = new JTable(dtm_dept);
    JScrollPane jsp_dept = new JScrollPane(jtb_dept, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JPanel jpanel_north = new JPanel();
    JButton jbtn_ins = new JButton("입력");
    JButton jbtn_upd = new JButton("수정");
    JButton jbtn_del = new JButton("삭제");
    JButton jbtn_sel = new JButton("조회");

    // 생성자
    public DeptTable3() {
        initDisplay();
    }

    // 화면그리기
    public void initDisplay() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jbtn_sel.addActionListener(this);
        jbtn_ins.addActionListener(this);
        jbtn_del.addActionListener(this);
        jbtn_upd.addActionListener(this);
        jpanel_north.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jpanel_north.add("North", jbtn_ins);
        jbtn_ins.setBackground(new Color(158, 9, 9));
        jbtn_ins.setForeground(Color.WHITE);

        jpanel_north.add("North", jbtn_upd);
        jbtn_upd.setBackground(new Color(158, 9, 9));
        jbtn_upd.setForeground(Color.WHITE);
        jpanel_north.add("North", jbtn_del);
        jbtn_del.setBackground(new Color(158, 9, 9));
        jbtn_del.setForeground(Color.WHITE);
        jpanel_north.add("North", jbtn_sel);
        jbtn_sel.setBackground(new Color(158, 9, 9));
        jbtn_sel.setForeground(Color.WHITE);
        this.add("North", jpanel_north);
        this.add("Center", jsp_dept);
        this.setSize(500, 400);
        this.setVisible(true);
        this.setTitle("부서관리시스템Ver1.0");

    }

    // 메인메소드
    public static void main(String[] args) {
        new DeptTable3();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj==jbtn_del){
            //인덱스값을 알아야 id값을 알아낸다 id값을 가져와서 삭제해야한다
            int index = jtb_dept.getSelectedRow();
            System.out.println(index);
            Integer deptno=Integer.parseInt((String)dtm_dept.getValueAt(index,0));
            System.out.println(deptno);


        }

        if (obj == jbtn_sel) {// 조회버튼 눌렀니?
            while (dtm_dept.getRowCount() > 0) {// 초기화 하고
                dtm_dept.removeRow(0);
            }
            for (int x = 0; x < depts.length; x++) {

                Vector<String> oneRow = new Vector<>();
                oneRow.add(depts[x][0]);
                oneRow.add(depts[x][1]);
                oneRow.add(depts[x][2]);
                dtm_dept.addRow(oneRow);// 전체 밀어넣기
            }

            for (int i = 0; i < depts.length; i++) {
                for (int j = 0; j < depts[i].length; j++) {
                    // System.out.print(depts[i][j] + " ");
                    dtm_dept.setValueAt("여기", 1, 1);
                    System.out.println(dtm_dept.getValueAt(i, j));

                } // end of inner for
                System.out.println();
            } // end of outter for
              // DefaultTableModel에 데이터 초기화 하기
        } // end of 조회이벤트

    }
}
