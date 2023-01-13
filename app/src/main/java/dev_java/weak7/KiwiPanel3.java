package dev_java.weak7;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KiwiPanel3 extends JPanel implements ActionListener {
    String header[] = { "부서번호", "부서명", "지역" };
	//String datas[][] = new String[0][3];
    String datas[][]={{"10","인사부","부산"}
                                   ,{"20","기술부","제주"}
                                   ,{"30","재정부","서울"}
                                };
	DefaultTableModel dtm_dept = new DefaultTableModel(datas, header);// 생성자 호출
	JTable jtb_dept = new JTable(dtm_dept);
	JScrollPane jsp_dept = new JScrollPane(jtb_dept, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//센터에 스크롤페인 붙일거야 테이블 붙이기

//JTable의 헤더 글자크기도 변경하기
JTableHeader jth= jtb_dept.getTableHeader();
KiwiApp kiwiApp=null;

    public KiwiPanel3(){
        initDisplay();

    }
    public KiwiPanel3(KiwiApp kiwiApp){
        this();
        this.kiwiApp=kiwiApp;
    }
    public void changeFontSize(){
        jth.setFont(KiwiPanel1.f);//헤더 폰트 설정
        jtb_dept.setFont(KiwiPanel1.f);//테이블 폰트설정
    }
    public void initDisplay() {
        if(KiwiPanel1.isSize){
            changeFontSize();
        }
        //JPanel은 디폴트레이아웃이 FlowLayout (borderlayout하고 쓰자)
        //JDialog,JFrame 디폴트레이아웃이 BorderLayout(동서남북)
        this.setLayout(new BorderLayout());
        this.add("Center",jsp_dept);
    }
public static void main(String[] args) {
    new KiwiPanel3();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
