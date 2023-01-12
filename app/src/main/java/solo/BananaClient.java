package solo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import dev_java.network2.Protocol;
import dev_java.network2.TalkClientThread;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class BananaClient  extends JFrame implements ActionListener{
//선언부
Socket socket= null;
ObjectOutputStream oos=null;
ObjectInputStream ois= null;
String nickName= null;

JPanel jp_second= new JPanel();
JPanel jp_second_south= new JPanel();
JButton jbtn_one= new JButton("1:1");
JButton jbtn_change= new JButton("대화명 변경");
JButton jbtn_font = new JButton("글자색");
JButton jbtn_exit = new JButton("나가기");
String cols[]= {"대화명"};
String data[][]=new String[0][1];
DefaultTableModel dtm= new DefaultTableModel(data,cols);
JTable jtb=new JTable(dtm);
JScrollPane jsp = new JScrollPane(jtb);
JPanel jp_first = new JPanel();
JPanel jp_first_south= new JPanel();
JTextField jtf_msg= new JTextField(20);
JButton jbtn_send = new JButton("보내기");
JTextArea jta_display = new JTextArea(15,38);
JScrollPane jsp_display = new JScrollPane(jta_display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//생성자
public void init(){
    try {
        socket= new Socket("192.168.10.78",4000);
        oos= new ObjectOutputStream(socket.getOutputStream());
        ois= new ObjectInputStream(socket.getInputStream());
        oos.writeObject(100+Protocol.separator+nickName);
        BananaClientThread tct = new BananaClientThread();
        tct.start();
    } catch (Exception e) {
        System.out.println(e.toString());
        // TODO: handle exception
    }
}
public void initDisplay(){
    jtf_msg.addActionListener(this);
    //nickName = JOptionPane.showInputDialog("닉네임 입력");
    this.setLayout(new GridLayout(1,2));
    jp_second.setLayout(new BorderLayout());
    jp_second.add("Center",jsp);
    jp_second_south.add(jbtn_one);
    jp_second_south.add(jbtn_change);
    jp_second_south.add(jbtn_font);
    jp_second_south.add(jbtn_exit);
    jp_second.add("South",jp_second_south);
    jp_first.setLayout(new BorderLayout());
    jp_first_south.add("Center",jtf_msg);
    jp_first_south.add("East",jbtn_send);
    this.add(jp_first);
    this.add(jp_second);
    this.setSize(800,500);
    this.setVisible(true);
}
    public static void main(String[] args) {
        BananaClient tc= new BananaClient();
        tc.initDisplay();
        tc.init();
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
