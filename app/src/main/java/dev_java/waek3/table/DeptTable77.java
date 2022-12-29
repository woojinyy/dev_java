package dev_java.waek3.table;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import dev_java.weak4.DeptVO;

public class DeptTable77 extends JFrame implements ActionListener {// 상속 extends
    // DeptTabl1 is a JFrame
    // 선언부
    // 왜 this를 넘겨야 하나요? 입력할건데?
    // Jtable7Dialog에서 부서번호 부서명 지역을 입력한 ㅎ ㅜ저장버튼틀 누르면
    // Vector<String[]>추가하고 추가된 로우를 포함하는 Vector가 부모창에
    // Refresh(재사용)되어야 하니까(부모클래스에 구현해야한다)호출해야 한다
    // 입력 수정 구분
    JTable7Dialog jtd7 = new JTable7Dialog(this);// 파라미터의 this는 DeptTable7타입이고 main 에서 호출된 생성자로 현재 메모리에 로딩중인 그 객체이다

    String header[] = { "부서번호", "부서명", "지역" };
    String datas[][] = new String[0][3];
    DefaultTableModel dtm_dept = new DefaultTableModel(datas, header);
    JTable jtb_dept = new JTable(dtm_dept);
    JScrollPane jsp_dept = new JScrollPane(jtb_dept, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JPanel jpanel_north = new JPanel();
    JButton jbtn_ins = new JButton("입력");
    JButton jbtn_upd = new JButton("수정");
    JButton jbtn_del = new JButton("삭제");
    JButton jbtn_sel = new JButton("조회");
    JButton jbtn_all = new JButton("상세보기");
    static Vector<DeptVO> vdata = new Vector<>(); 

    // 생성자
    public DeptTable77() {
        initDisplay();
    }

    // 화면그리기
    public void initDisplay() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jbtn_sel.addActionListener(this);
        jbtn_ins.addActionListener(this);
        jbtn_del.addActionListener(this);
        jbtn_upd.addActionListener(this);
        jbtn_all.addActionListener(this);
        jpanel_north.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jpanel_north.add("North", jbtn_ins);
        jbtn_ins.setBackground(new Color(18, 10, 50));
        jbtn_ins.setForeground(Color.WHITE);
        jpanel_north.add("North", jbtn_upd);
        jbtn_upd.setBackground(new Color(10, 50, 50));
        jbtn_upd.setForeground(Color.WHITE);
        jpanel_north.add("North", jbtn_del);
        jbtn_del.setBackground(new Color(28, 200, 100));
        jbtn_del.setForeground(Color.WHITE);
        jpanel_north.add("North", jbtn_sel);
        jbtn_sel.setBackground(new Color(20, 150, 150));
        jbtn_sel.setForeground(Color.WHITE);
        jpanel_north.add("North", jbtn_all);
        jbtn_all.setBackground(new Color(250, 100, 90));
        jbtn_all.setForeground(Color.WHITE);
        this.add("North", jpanel_north);
        this.add("Center", jsp_dept);
        this.setSize(500, 400);
        this.setVisible(true);
        this.setTitle("부서관리시스템Ver1.0");
    }
    // 새로고침- Vector에 담긴 String[ ] 출력하기
    // 입력, 수정화면에서 저장 버튼 누르면 Vector에 String[] 추가하고
    // 그 다이얼로그 화면은 닫히고 부모창은 새로고침 처리한다.
    // 따라서 다이얼로그창에 부모클래스와 refreshData메소드를 호출해야 한다
    // 인스턴스화 할 때 파라미터에 this를 넘겨서 사용할 수 있도록 할것

    public void refreshData() {
        System.out.println("refreshData 호출");// 저장버튼 눌렀을 때
        // 입력 수정 전 조회된 정보 삭제먼저
        while (dtm_dept.getRowCount() > 0) {
            dtm_dept.removeRow(0);
        }
        if (DeptTable7.vdata.size() <= 0) {
            JOptionPane.showMessageDialog(this, "조회 결과가 없습니다.", "INFO", JOptionPane.INFORMATION_MESSAGE);
            return;// refeshData탈출
        }
        System.out.println("DeptTable7: " + vdata.size());
        // 벡터의 크기만큼 반복하면서 dtm_dept데이터셋에 벡터추가
        for (int i = 0; i < vdata.size(); i++) {
            DeptVO oneRow = vdata.get(i);
            Vector<Object>vone = new Vector<>();
            vone.add(oneRow.getDeptno());
            vone.add(oneRow.getDname());
            vone.add(oneRow.getLoc());
            dtm_dept.addRow(vone);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        // 조회할거야?
        if (obj == jbtn_sel) {
            refreshData();
        }
        // 입력 눌렀니?
        else if (obj == jbtn_ins) {
            jtd7.set("입력", true, null);
        }
        // 수정?
        else if (obj == jbtn_upd) {
            // 어떤 로우를 수정할거니?
            // JTable목록에서 선택한 로우의 index를 값을 가져옴
            int index = jtb_dept.getSelectedRow();
            // 데이터 객체로 벡터를 사용중 벡터에서 꺼낸 값을 String[]초기화
            // 테이블의 양식 폼인 JTable이벤트로 얻어옴
            DeptVO pdVO= vdata.get(index);
            jtd7.set("수정", true, pdVO);
        }
        // 상세보기?
        else if (obj == jbtn_all) {
            jtd7.set("상세보기", true, header);
        }
    }

    public static void main(String[] args) {
        new DeptTable7();
    }

}
// /*해당 로우를 선택하는 이벤트는 데이터셋인 defaulttablemodel이 아니라 jatable에 이벤트처리
// *그러나 부서번호를 읽어오는 것은 데이터셋인 defaulttablemodel 에서 가져옴
// * 이렇게 가져온 부서번호는 set메소드의 3번째 파라미터로 전달
// * 따라서 DeptTable7에서 수정 혹은 상세보기를 누를 때 해당 로우의 선택 여부를 체크
// * 선택된 로우가 없으면 수정 혹은 상세보기 원하는 로우를 선택하시오 메세지 처리 후
// * 정상적으로 이용할 수 있도록 유도
// *입력이나 수정시에는 JtextField를 활성화 하고
// *상세보기 시에는 JTextField 를 얼려야 한다.
// * /