package dev_java.waek3.table;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dev_java.weak4.DeptVO;

//JDialog 도 디폴트가 BorderLayout임 jp_centers를 중앙 배치

public class JTable7Dialog extends JDialog implements ActionListener {
    // 선언부
    DeptVO pdVO = null;// 왜 널을 주는지 설명할 수 있나?

    DeptTable7 deptTable7 = null;
    JPanel jp_center = new JPanel();
    JScrollPane jsp_center = new JScrollPane(jp_center);
    JPanel jp_south = new JPanel();
    JLabel jlb_deptno = new JLabel("부서번호");
    JTextField jtf_deptno = new JTextField(10);
    JLabel jlb_dname = new JLabel("부서명");
    JTextField jtf_dname = new JTextField(20);
    JLabel jlb_loc = new JLabel("지역");
    JTextField jtf_loc = new JTextField(20);
    JLabel jlb_sample = new JLabel("자동완성");
    JTextField jtf_sample = new JTextField(20);
    JLabel jlb_check = new JLabel("검사");
    JTextField jtf_check = new JTextField(20);
    // jp_south 속지
    JButton jbtn_save = new JButton("저장");
    JButton jbtn_sample = new JButton("자동완성");
    JButton jbtn_check = new JButton("중복검사");
    JButton jbtn_close = new JButton("닫기");

    // 생성자
    public JTable7Dialog() {
    }

    public JTable7Dialog(DeptTable7 deptTable7) {
        this.deptTable7 = deptTable7;
        initDisplay();// 옮겨야해 JTable7dialog가 아니고
    }

    // 화면그리기
    public void initDisplay() {
        jbtn_save.addActionListener(this);
        jbtn_close.addActionListener(this);
        jbtn_sample.addActionListener(this);
        jbtn_check.addActionListener(this);
        jp_center.setLayout(null);
        jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jlb_deptno.setBounds(20, 20, 100, 20);
        jtf_deptno.setBounds(120, 20, 100, 20);
        jlb_dname.setBounds(20, 45, 100, 20);
        jtf_dname.setBounds(120, 45, 150, 20);
        jlb_loc.setBounds(20, 70, 100, 20);
        jtf_loc.setBounds(120, 70, 150, 20);
        jlb_sample.setBounds(20, 70, 100, 20);
        jtf_sample.setBounds(120, 70, 150, 20);
        jlb_check.setBounds(120, 70, 100, 20);
        jtf_check.setBounds(120, 70, 150, 20);
        jp_center.add(jlb_deptno);
        jp_center.add(jtf_deptno);
        jp_center.add(jbtn_check);
        jp_center.add(jlb_dname);
        jp_center.add(jtf_dname);
        jp_center.add(jlb_loc);
        jp_center.add(jtf_loc);
        jp_south.add(jbtn_save);
        jp_south.add(jbtn_close);
        jp_south.add(jbtn_sample);
        this.add("Center", jsp_center);
        this.add("South", jp_south);
        this.setSize(400, 360);
        this.setVisible(false);
    }

    // 각 컬럼(부서집합-부서번호,부서명,지역)의 값들을 설정하거나
    // 읽어오는 getter/setter메소드 이다 단순 화면의 값을 가져오고 뿌리는 반복적인 행위 캡슐레이션 아니다
    public String getDeptno() {
        return jtf_deptno.getText();
    }

    public void setDeptno(String deptno) {
        jtf_deptno.setText(deptno);
    }

    public String getDname() {
        return jtf_dname.getText();
    }

    public void setDname(String dname) {
        jtf_dname.setText(dname);
    }

    public String getLoc() {
        return jtf_loc.getText();
    }

    public void setLoc(String loc) {
        jtf_loc.setText(loc);
    }

    // 아래메소드는 DeptTable7에서 호출됨
    // actionPerformed에서 이벤트(입력 수정 상세보기)가 발생되면 호출됨
    // 메소드의 파라미터 자리는 call by value 에 의해서 결정됨
    public void set(String title, boolean isView, DeptVO pdVO, boolean isEdit) {
        this.setTitle(title);
        this.setVisible(isView);
        this.pdVO = pdVO;
        setValue(pdVO);
        setEditable(isEdit);
    }

    // 입력 혹은 수정일때는 true
    // 상세보기일 떄는 false줘서 림
    private void setEditable(boolean isEdit) {
        jtf_deptno.setEditable(isEdit);
        jtf_dname.setEditable(isEdit);
        jtf_loc.setEditable(isEdit);
    }

    public void setValue(DeptVO pdVO) {
        // 입력을 위한 윈도우 설정- 모든 값을 빈문자열로 셋팅
        if (pdVO == null) {
            setDeptno("");
            setDname("");
            setLoc("");

        } else {
            setDeptno(String.valueOf(pdVO.getDeptno()));
            setDname(pdVO.getDname());
            setLoc(pdVO.getLoc());
        }
        // 상세조회 수정시는 배열로 받은 값으로 세팅

    }// end of setValue

    // 메인
    public static void main(String[] args) {
        new JTable7Dialog(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == jbtn_save) {

            // dialog화면에서 저장버튼 하나로 000는 입력처리를 xxx는 수정처리한다
            // 부모창에서 _ _ _버튼이 눌리면 set메소드 호출
            // 입력버튼이 눌리면 세번째 파라미터에 null을 입력한다
            // 수정버튼이 눌리면 JTable에서 선택된 로우의 인덱스로 DeptVO를 추출한다
            // JTable에서 선택된 로우의 인덱스로 DeptVO를 추출해서 세번째 파라미터에
            // null대신 입력한다
            if (pdVO != null) {

                for (int i = 0; i < DeptTable7.vdata.size(); i++) {
                    DeptVO comVO = DeptTable7.vdata.get(i);
                    if (pdVO.getDeptno() == comVO.getDeptno()) {// 벡터에서 추출한 부서번호와 DeptTable7에서 가져온DeptVO부서번호 비교
                        DeptVO updVO = DeptVO.builder().deptno(Integer.parseInt(getDeptno())).dname(getDname()).loc(getLoc())
                                .build();
                        DeptTable7.vdata.remove(i);
                        DeptTable7.vdata.add(i, updVO);
                    }
                }
                deptTable7.refreshData();
                this.dispose();// 자손이 닫혀야해
            }else{
				DeptVO insVO = DeptVO.builder().deptno(Integer.parseInt(getDeptno())).dname(getDname()).loc(getLoc())
						.build();
				System.out.println("before : " + DeptTable7.vdata.size());
				DeptTable7.vdata.add(insVO);
				System.out.println("after : " + DeptTable7.vdata.size());
				deptTable7.refreshData();
				this.dispose();
            }


        }
         else if (obj == jbtn_sample) {
            setDeptno("30");
            setDname("운영부");
            setLoc("세종");
        }
    }
}
