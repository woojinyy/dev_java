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
import dev_java.network1.TimeClient;
import dev_java.network1.TimeClientView;
import dev_java.network1.TimeServer;

public class DeptTable7 extends JFrame implements ActionListener {

    JTable7Dialog jtd7 = new JTable7Dialog(this);

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
    JButton jbtn_det = new JButton("상세보기");
    static Vector<DeptVO> vdata = new Vector<>(); // 벡터 안에 타입이 String[]

    // 생성자
    public DeptTable7() {
        initDisplay();
    }

    // 화면그리기
    public void initDisplay() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jbtn_sel.addActionListener(this);
        jbtn_ins.addActionListener(this);
        jbtn_del.addActionListener(this);
        jbtn_upd.addActionListener(this);
        jbtn_det.addActionListener(this);
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
        jpanel_north.add("North", jbtn_det);
        jbtn_det.setBackground(new Color(250, 100, 90));
        jbtn_det.setForeground(Color.WHITE);
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
                for (int i = 0; i < vdata.size(); i++) {
                DeptVO oneRow = vdata.get(i);
                Vector<Object> vone = new Vector<>();
                vone.add(oneRow.getDname());
                vone.add(oneRow.getLoc());
                vone.add(oneRow.getDeptno());
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
            // DeptVO pdVO= vdata.get(index);
            jtd7.set("입력",true, null, true);
        }
        // 수정?
        else if (obj == jbtn_upd) {
            int index = jtb_dept.getSelectedRow();
            DeptVO pdVO= vdata.get(index);
            jtd7.set("수정", true, pdVO, true);
        }
        // 상세보기?
        else if (obj == jbtn_det) {
            int index =jtb_dept.getSelectedRow();
            if(index==-1){//-1은 end of filed의미
                JOptionPane.showConfirmDialog(this, "상세보기 대상 선택");
                return;
            }
            DeptVO pdVO = vdata.get(index);
            jtd7.set("상세보기", true, pdVO, true);
        }
        //삭제
        else if(obj==jbtn_del){
            int index = jtb_dept.getSelectedRow();
        if(index==-1){//-1은 end of filed의미
            JOptionPane.showConfirmDialog(this, "삭제 대상 선택");
            return;
        }
        vdata.remove(index);
        refreshData();
    } 
    }
    public static void main(String[] args) {
        new DeptTable7();
    }
}



