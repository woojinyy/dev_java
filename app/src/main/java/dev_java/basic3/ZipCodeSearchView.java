package dev_java.basic3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import dev_java.util.DBConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
public class ZipCodeSearchView extends JFrame implements ItemListener, FocusListener, ActionListener,MouseListener {
    // 선언부
    // 사용자가 선택한 시도
    String userzdo = null;
    // 사용자가 선택한 시구 중분류
    String usersigu = null;
    // 사용자가 선택한 동 소분류
    String userdong = null;
    // DB에서 가져온 시도[]
    String[] dbzdo = null;
    // DB에서 가져온 시구[]
    String[] dbsigu = null;
    // DB에서 가져온 동[]
    String[] dbdong = null;
    String totals[] = { "전체" };

    // 오라클과 연동을 해야해서 게으른 인스턴스화 해야해
    // 북쪽에 붙일 속지 JTextField, JButton
    // FlowLayout 중앙에서 좌우로 펼쳐지면서 배치가 됨
    JPanel jp_north = new JPanel();// 디폴트 레이아웃 FlowLayout
    JComboBox jcb_zdo = null;
    JComboBox jcb_sigu = null;
    JComboBox jcb_dong = null;
    //////////////////////////////// [DB연동시작]/////////////////////////////
    // 물리적으로 떨어져있는 오라클 서버에 접속하는 데 필요한 공통 코드 작성
    DBConnection dbMGR = new DBConnection();// Driverclass, connection info
    // 드라이버클래스 로딩-> 오라클서버에 ip계정이름 패스워드로 커넥션 con을 만든다
    Connection con = null;// 인터페이스
    PreparedStatement psmt = null;// 인터페이스 동적쿼리
    ResultSet rs = null;// 커서조작 인터페이스 next() ,previous() 커서 다음이동,이전이동...
    /////////////////////////////////////////////////////////////////////////

    // 동이름 입력받는 text field 와 조회버튼 추가
    // 생성자 파라미터 자리를 이용하여 추가적 메소드 호출없이 해당 화면 초기화

    // 이른 인스턴스화
    JTextField jtf_search = new JTextField("동이름", 20);// 클릭하면 문자가 사라지지않아

    JButton jbtn_search = new JButton("조회");
    // 테이블 생성

    // String[] cols = { "우편번호", "주소" };
    // String[][] data = new String[3][3];// 해더
    // DefaultTableModel dtm_zipcode = new DefaultTableModel(data, cols);
    // JTable jtb_zipcode = new JTable(dtm_zipcode);
    // JTableHeader jth_zipcode = new JTableHeader();// 해더 꾸미기
    // JScrollPane jsp_zipcode = new JScrollPane(jtb_zipcode,
    // JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
    // JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    String[] cols = { "우편번호", "주소" };
    String[][] data = new String[0][3];
    DefaultTableModel dtm_zipcode = new DefaultTableModel(data, cols);
    JTable jtb_zipcode = new JTable(dtm_zipcode);
    JTableHeader jth_zipcode = jtb_zipcode.getTableHeader();
    JScrollPane jsp_zipcode = new JScrollPane(jtb_zipcode, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            MemberShip memberShip = null;
    // 생성자
    public ZipCodeSearchView() {
        jtf_search.addActionListener(this);
        jbtn_search.addActionListener(this);
        jtf_search.addActionListener(this);
        jtf_search.addFocusListener(this);
        dbzdo = getZDOList();
        jcb_zdo = new JComboBox(dbzdo);
        jcb_zdo.addItemListener(this);
        jcb_sigu = new JComboBox(totals);
        jcb_sigu.addItemListener(this);
        jcb_dong = new JComboBox(totals);
        jcb_dong.addItemListener(null);

    }

    public ZipCodeSearchView(MemberShip memberShip) {
        this();// 나자신의 디폴트 생성자 호출
        this.memberShip = memberShip;
        this.initDisplay();
    }

    // 대분류 정보 초기화에 필요한 DB조회하기 구현
    public String[] getZDOList() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT '전체' zdo FROM dual ");
        sql.append("UNION ALL                               ");
        sql.append("SELECT zdo                              ");
        sql.append("FROM (                                     ");
        sql.append("SELECT distinct(zdo) zdo      ");
        sql.append("FROM  zipcode_t                    ");
        sql.append("ORDER BY zdo asc )                ");
        try {// connection,statement(정적) preparedstatment(동적) resultset(커서이동하면서 데이터 존재->
             // true) while
            con = dbMGR.getConnection();// con 의 주소번지 확인되면 오라클서버와 연결통로 확보되었다
            psmt = con.prepareStatement(sql.toString());
            // 오라클에서 생성된 테이블의 커서디폴트위치 is top
            rs = psmt.executeQuery();
            Vector<String> v = new Vector<>();
            // rs.previous();//커서 이전으로
            while (rs.next()) {
                String userzdo = rs.getString("zdo");
                v.add(userzdo);
            }
            dbzdo = new String[v.size()];
            v.copyInto(dbzdo);
        } catch (SQLException se) {
            System.out.println(se.toString());
            System.out.println(sql.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 사용자원반납
            // 생략해도 언젠가 반납은 이루어짐, 명시적으로 반납차리 권장
            // 오라클 서버에서 커넥션을 강제로 종료시키기때문에
            try {
                dbMGR.freeConnection(con, psmt, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dbzdo;
    }// end of getZDOList

    public String[] getSIGUList(String userzdo) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT '시군구' sigu FROM dual ");
        sql.append("UNION ALL                                  ");
        sql.append("SELECT sigu                                ");
        sql.append("FROM (                                        ");
        sql.append("SELECT distinct(sigu)  sigu       ");
        sql.append("FROM  zipcode_t                       ");
        sql.append("WHERE zdo=:zdo                       ");
        sql.append("ORDER BY sigu asc )                 ");
        try {
            con = dbMGR.getConnection();// con 의 주소번지 확인되면 오라클서버와 연결통로 확보되었다
            psmt = con.prepareStatement(sql.toString());
            psmt.setString(1, userzdo);
            // 오라클에서 생성된 테이블의 커서디폴트위치 is top
            rs = psmt.executeQuery();
            Vector<String> v = new Vector<>();
            // rs.previous();//커서 이전으로
            while (rs.next()) {
                String usersigu = rs.getString("sigu");
                v.add(usersigu);
            }
            dbsigu = new String[v.size()];
            v.copyInto(dbsigu);
        } catch (SQLException se) {
            System.out.println(se.toString());
            System.out.println(sql.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 사용자원반납
            // 생략해도 언젠가 반납은 이루어짐, 명시적으로 반납차리 권장
            // 오라클 서버에서 커넥션을 강제로 종료시키기때문에
            try {
                dbMGR.freeConnection(con, psmt, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dbsigu;
    }// end of getSIGUList

    public String[] getDONGList(String usersigu) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT '읍면동' dong FROM dual ");
        sql.append("UNION ALL                                  ");
        sql.append("SELECT dong                                ");
        sql.append("FROM (                                        ");
        sql.append("SELECT distinct(dong)  dong       ");
        sql.append("FROM  zipcode_t                       ");
        sql.append("WHERE sigu=:sigu                       ");
        sql.append("ORDER BY dong asc )                 ");
        try {
            con = dbMGR.getConnection();// con 의 주소번지 확인되면 오라클서버와 연결통로 확보되었다
            psmt = con.prepareStatement(sql.toString());
            psmt.setString(1, usersigu);
            // 오라클에서 생성된 테이블의 커서디폴트위치 is top
            rs = psmt.executeQuery();
            Vector<String> v = new Vector<>();
            // rs.previous();//커서 이전으로
            while (rs.next()) {
                String userdong = rs.getString("dong");
                v.add(userdong);
            }
            dbdong = new String[v.size()];
            v.copyInto(dbdong);
        } catch (SQLException se) {
            System.out.println(se.toString());
            System.out.println(sql.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 사용자원반납
            // 생략해도 언젠가 반납은 이루어짐, 명시적으로 반납차리 권장
            // 오라클 서버에서 커넥션을 강제로 종료시키기때문에
            try {
                dbMGR.freeConnection(con, psmt, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dbdong;
    }// end of getDONGList
    public void refreshData(String zdo, String dong) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT zipcode,address                          ");
        sql.append("FROM zipcode_t                                       ");
        sql.append("WHERE 1=1                                                 ");
        if (zdo != null && zdo.length() > 0) {// 빈문자열 필터링
            sql.append("AND zdo=?                                 ");
        } // zdo가 존재 할 때만
        if (zdo != null && dong.length() > 0) {// 빈문자열 필터링
            sql.append("AND dong LIKE ?||'%'                               ");
        } // dong이입력받을 때만
        int i = 1;// 순서가 바뀌어도 수정하기 쉽게
        try {
            con = dbMGR.getConnection();// 오라클서버연결
            // 타입이 다를경우 ClassCastingException
            psmt = con.prepareStatement(sql.toString());// 들어있는 타입이 String이라 문제될건없다
            if (zdo != null && zdo.length() > 0) {
                psmt.setString(i++, zdo);
            }
            if (dong != null && zdo.length() > 0) {
                psmt.setString(i++, dong);
            }
            // 입력 수정 삭제 executeupdate()사용리턴타입은 int
            // 조회만 할 경우 executeQuery()를 사용 리턴타입은 Resultset
            // 테이블을 생성할 때는 execute()를 사용
            // 업무가 바뀌더라도 변하는 건 테이블명과 컬럼명 일뿐 다른건 그대로 재사용 가능
            // orm솔루션-> jpa기술 출현 -> 활용
            // JPA(Hibernate-쿼리문이 없다)
            rs = psmt.executeQuery();
            List<Map<String, Object>> zipList = new ArrayList<>();
            Map<String, Object> rmap = null;// 매번 초기화 해야히 게으른 인스턴스화
            while (rs.next()) {
                rmap = new HashMap<>();// 경합이 없으니까
                rmap.put("zipcode", rs.getString("zipcode"));// 표현은 이게 더 좋다
                // rmap.put("zipcode",rs.getString(1));
                rmap.put("address", rs.getString("address"));
                zipList.add(rmap);
            }
            // 화면처리하기 -테이블 새로고침
            // 1st.조회결과가 있니?
            if (zipList.size() > 0) {
                // 조회를 연속하여 요청할 경우 기존에 조회된 화면은 지워주자
                while (dtm_zipcode.getRowCount() > 0) {// JTable은 양식일 뿐 실제 데이터는 DefaultTableModel에 있다.
                    dtm_zipcode.removeRow(0);
                } // edn of while
                  // 새로 조회된 결과 출력
                for (int x = 0; x < zipList.size(); x++) {
                    Map<String, Object> rmap2 = zipList.get(x);
                    Vector<String> oneRow = new Vector<>();
                    oneRow.add(0, rmap2.get("zipcode").toString());
                    oneRow.add(1, rmap2.get("address").toString());
                    dtm_zipcode.addRow(oneRow);
                } // end of for
            }
        } catch (SQLException se) {
            // TODO: handle exception
        } catch (Exception e) {
        } finally {
            // 자원회수 언젠간 JVM이 해주는데 시간을 당겨
            dbMGR.freeConnection(con, psmt, rs);
        }
    }// end of refreshData
    // 화면처리부
    public void initDisplay() {
        jtb_zipcode.addMouseListener(this);
        jth_zipcode.setBackground(Color.ORANGE);
        jth_zipcode.setFont(new Font("맑은고딕", Font.BOLD, 20));
        jtb_zipcode.getColumnModel().getColumn(0).setPreferredWidth(100);// 간격 우편주소
        jtb_zipcode.getColumnModel().getColumn(1).setPreferredWidth(500);// 간격 주소
        jtb_zipcode.setGridColor(Color.RED);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// x를 눌로 joy를 표하시오
        jp_north.add(jcb_zdo);
        jp_north.add(jcb_sigu);
        jp_north.add(jcb_dong);
        jp_north.add(jtf_search);
        jp_north.add(jbtn_search);
        this.add("North", jp_north);
        this.add("Center", jsp_zipcode);
        this.setSize(630, 400);
        this.setVisible(true);
     
    }
    // 메인
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(isDefaultLookAndFeelDecorated());
        ZipCodeSearchView zcsv = new ZipCodeSearchView();
        zcsv.initDisplay();
    }
    @Override
    public void itemStateChanged(ItemEvent ie) {
        // 이벤트 감지 소스 가져오기
        Object obj = ie.getSource();
        Object obj1 = ie.getSource();
        // 너 zdo콤보박스?
        if (obj == jcb_zdo) {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                System.out.println("선택한 zdo===" + dbzdo[jcb_zdo.getSelectedIndex()]);
                userzdo = dbzdo[jcb_zdo.getSelectedIndex()];
                dbsigu = getSIGUList(userzdo);
                // 대분류가 결정이 되었을 때 usersigu를 초기화 해줘야 함
                // 기존에 디폴트로 전체 상수값을 넣어두었으니 이것을 삭제하고
                jcb_sigu.removeAllItems();
                // 새로운 DB서버에서 읽어온 값으로 아이템을 추가해야 한다 = 초기화
                for (int i = 0; i < dbsigu.length; i++) {
                    jcb_sigu.addItem(dbsigu[i]);
                }
            } else if (obj1 == jcb_sigu) {
                if (ie.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("선택한 sigu===" + dbsigu[jcb_sigu.getSelectedIndex()]);
                    usersigu = dbsigu[jcb_sigu.getSelectedIndex()];
                    dbdong = getDONGList(usersigu);
                    jcb_dong.removeAllItems();
                    for (int j = 0; j < dbdong.length; j++) {
                        jcb_dong.addItem(dbdong[j]);
                    }
                }
            }
            // else if (obj == jcb_dong) {
            // if (ie.getStateChange() == ItemEvent.SELECTED) {
            // System.out.println("선택한 dong===" + dbdong[jcb_dong.getSelectedIndex()]);
            // userdong = dbdong[jcb_dong.getSelectedIndex()];
            // dbdong = getDONGList(userdong);
            // jcb_dong.removeAllItems();
            // for (int k = 0; k < dbdong.length; k++) {
            // jcb_dong.addItem(dbdong[k]);
            // }
            // }
            // }
        }
    }
    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == jtf_search) {
            jtf_search.setText("");// 검색창 클릭하면 ""빈칸으로 바꿔줘
        }
    }
    // 구현할 필요 없는 메소드 but 지우면 에러
    // 추상메소드이기 때문에
    // 인터페이스를 impelments하면 반드시 구현체 클래스가 있어야 한다
    // 인터페이스가 소지한 모든 추상메소드를 구현해야 한다.
    @Override
    public void focusLost(FocusEvent e) {
        // 내용이 없어도 좌중괄호 우중괄호로 묶여있으면 구현체이다
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (jbtn_search == obj || jtf_search == obj) {
            String myDong = jtf_search.getText();
           refreshData(userzdo,myDong);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getClickCount()==2){
            //System.out.println("더블클릭");
            //JTable에서 사용자가 선택한 row의 index값을 가져와서 담아둔다
            int index=jtb_zipcode.getSelectedRow();
            for(int i =0;i<dtm_zipcode.getRowCount();i++){
                if(jtb_zipcode.isRowSelected(i)){//선택이 됐다면 가져온다
                    String address=dtm_zipcode.getValueAt(i, 1).toString(); 
                    memberShip.jtf_zipcode.setText(String.valueOf(dtm_zipcode.getValueAt(i,0)));
                    memberShip.jtf_address.setText(address);
                    memberShip.jtf_zipcode.setText(String.valueOf(dtm_zipcode.getValueAt(i, 0)));
					memberShip.jtf_address.setText(address);
					this.dispose();

                }
            }
            //jtb_zipcode.getSelectedRows();
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}
// implements ->오버라이드 -> 핸들러