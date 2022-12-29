package dev_java.waek3.quiz;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Vector;

public class AddressBook implements ActionListener {
    // 선언부----------------------------------------------
    // 이미지 경로 선언
    String imgPath = "D:\\vscod_java\\dev_java\\app\\src\\main\\java\\dev_java\\images\\address\\";
    // 툴바 및 타이틀 이미지 설정
    JToolBar jtb = new JToolBar();
    // 이미지 아이콘 추가
    ImageIcon titlecon = new ImageIcon(imgPath + "memo.png");
    JFrame jf = new JFrame();
    // 메뉴바 구성
    JMenuBar jmb = new JMenuBar();
    JMenu jm_file = new JMenu("File");
    JMenuItem jmi_db = new JMenuItem("DB연동 확인");
    JMenuItem jmi_all = new JMenuItem("전체조회");
    JSeparator js_exit = new JSeparator();
    JMenuItem jmi_exit = new JMenuItem("종료");
    JMenu jm_edit = new JMenu("Edit");
    JMenuItem jmi_ins = new JMenuItem("입력");
    JMenuItem jmi_upd = new JMenuItem("수정");
    JMenuItem jmi_del = new JMenuItem("삭제");
    JMenuItem jmi_read = new JMenuItem("상세보기");
    JPanel jp_north = new JPanel();
    JTextArea jta = null;
    JTextField jtf = new JTextField(10);
    JButton jbtns[] = new JButton[4];
    JButton jbtn_del = new JButton();
    JButton jbtn_ins1 = new JButton();
    JButton jbtn_upd = new JButton();
    JButton jbtn_read = new JButton();
    AddressDialog aDialog = new AddressDialog();

    // 중앙에 테이블 추가
    // JTable Header에 들어갈 문자열 선언
    String[] header = { "번호", "이름", "H.P" };
    // JTable은 양식만 제공할 뿐이고 데이터를 담을 클래스는 별도로 필요함
    String[][] datas = new String[3][3];
    // JTable에 들어갈 실제 데이터 셋을 관리할 수 있는 클래스 선언
    // JTable에 보여지는 실제 데이터는 DefaultTableModel클래스를 통해 제어 해야 함을 의미
    DefaultTableModel dtm_addr = new DefaultTableModel(datas, header);
    // 데이터 셋을 JTable생성시 파라미터로 매칭하기
    JTable jtb_addr = new JTable(dtm_addr);
    // DefaultTableModel의 행 숫자가 많아지는 경우 스크롤바 추가해야함
    // JScrollPane은 스크롤바를 품고 있는 일종의 속지
    // 첫번째 파라미터는 양식을 가진JTable이고 두번째는 수직 스크롤바 정책을 세번째는 수평스크롤바 정책을 정해줌
    JScrollPane jsp_addr = new JScrollPane(jtb_addr, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    public AddressBook() {
        initDisplay();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == jmi_all) {// 전체조회
            String members[][] = {
                    { "1", "이순신", "010-1111-2222" }, { "2", "강감찬", "010-1111-3333" }, { "3", "김춘추", "010-1111-4444" }
            };
            // 이미 테이블에 조회된 정보가 있는 경우 먼저 삭제하고 데이터 추가
            while (dtm_addr.getRowCount() > 0) {
                dtm_addr.removeRow(0);
            }
            for (int i = 0; i < members.length; i++) {
                Vector<Object> oneRow = new Vector<>();// 꺽새 =generic
                oneRow.add(members[i][0]);
                oneRow.add(members[i][1]);
                oneRow.add(members[i][2]);
                dtm_addr.addRow(oneRow);
            }
            // 익명 클래스 문법 사용 -자바 람다식, 자바스크립트,코틀린 Arrow Function 문법과 유사
            jsp_addr.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
                public void adjustmentValueChanged(AdjustmentEvent e) {
                    JScrollBar jsb = (JScrollBar) e.getSource();
                    jsb.setValue(jsb.getMaximum());
                }
            });
        }
        if (obj == jbtn_ins1 || obj == jmi_ins) {// 수정버튼 누른거?
            aDialog.SetDialog(jmi_ins.getText(), true);
        } else if (obj == jbtn_upd||obj==jmi_upd) {// 상세보기버튼 누른거?
            aDialog.SetDialog(jmi_upd.getText(), true);
        } else if (obj == jbtn_read||obj==jmi_read) {// 버튼 누른거?
            aDialog.SetDialog(jmi_read.getText(), true);
        }

        if (obj == jmi_exit) {
            // System.exit(0);//전체 싹다 종료
            jf.dispose();// jf만 종료
        }
    }

    public void initDisplay() {
        // 화면그리기-----------------------------------------
        jm_file.setMnemonic('F');
        jm_edit.setMnemonic('E');
        jbtn_ins1.setIcon(new ImageIcon(imgPath + "new.gif"));
        jbtn_upd.setIcon(new ImageIcon(imgPath + "update.gif"));
        jbtn_del.setIcon(new ImageIcon(imgPath + "delete.gif"));
        jbtn_read.setIcon(new ImageIcon(imgPath + "detail.gif"));
        jtb.add(jbtn_ins1);
        jtb.add(jbtn_del);
        jtb.add(jbtn_upd);
        jtb.add(jbtn_read);
        jbtn_ins1.setToolTipText("입력");
        jbtn_del.setToolTipText("삭제");
        jbtn_upd.setToolTipText("수정");
        jbtn_read.setToolTipText("상세보기");
        jmi_all.addActionListener(this);// 이벤트 소스와 이벤트 핸들러 클래스 매칭
        jbtn_del.addActionListener(this);// 이벤트 소스와 이벤트 핸들러 클래스 매칭
        jmi_exit.addActionListener(this);
        jmi_ins.addActionListener(this);
        jmi_upd.addActionListener(this);
        jmi_read.addActionListener(this);
        jbtn_ins1.addActionListener(this);
        jbtn_upd.addActionListener(this);
        jbtn_read.addActionListener(this);
        jtf.addActionListener(this);
        jmb.add(jm_file);
        jmb.add(jm_edit);
        jm_file.add(jmi_all);
        jm_file.add(js_exit);
        jm_file.add(jmi_db);
        jm_file.add(jmi_exit);
        jm_edit.add(jmi_ins);
        jm_edit.add(jmi_upd);
        jm_edit.add(jmi_del);
        jm_edit.add(jmi_read);

        jf.setTitle("주소록Ver1.0");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setJMenuBar(jmb);
        jf.setSize(500, 450);
        jf.setVisible(true);
        jf.add("North", jtb);
        jf.add("Center", jsp_addr);
        jf.setIconImage(titlecon.getImage());

    }

    public static void main(String[] args) {
        new AddressBook();
    }
}
