package solo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.border.Border;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BananaChatRoom extends JFrame implements Runnable, ActionListener {
    // 선언부
    String imgPath = "D:\\vscod_java\\dev_java\\app\src\\main\\java\\dev_java\\images\\Banana\\";
    ImageIcon background = new ImageIcon(imgPath + "rooom_back.png");
    ImageIcon sendIcon = new ImageIcon(imgPath + "sendbutton.png");
    Container con = this.getContentPane();

    JTextField textField = new JTextField(20);
    JTextArea textArea = new JTextArea(15, 38);
    JPanel jp = new JPanel();
    JPanel jp_north = new JPanel();
    JPanel jp_south = new JPanel();
    JButton jbtn_send = new JButton("전송");
    JButton jbtn_back = new JButton("이전");
    JLabel label = new JLabel();
    JLabel sendlabel = new JLabel();
    final JTextPane textPane = new JTextPane();
    JScrollPane jsp = new JScrollPane();
    JViewport viewport = new JViewport() {
    // 생성자
 

    @Override
    protected void paintComponent(Graphics g) {
        Image img = background.getImage(); //
        // Image grayImage = GrayFilter.createDisabledImage(img);
        setOpaque(false);
        Graphics2D gd = (Graphics2D) g;
        gd.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
        g.drawImage(img, 0, 0, this);
        super.paintComponent(g);
        }
        };
        // viewport.setOpaque(false);
    
    
    public void initDisplay() {
        textPane.setOpaque(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 종료
        jsp.setOpaque(true);
        jsp.setViewport(viewport);
        jsp.setViewportView(textPane);
        con.add(jsp);
        this.setSize(350, 600);
        this.setVisible(true);
        jbtn_send.addActionListener(this);
        jbtn_back.addActionListener(this);
        textField.addActionListener(this);
        textArea.setEditable(false);
        jp.add("Center", textField);
        jp.setLayout(new BorderLayout());
        jp_north.setLayout(new BorderLayout());
        jp_north.add("East", jbtn_back);
        jp_south.setLayout(new BorderLayout());
        jp_south.add("Center", textField);// 메시지 작성창
        jp_south.add("East", jbtn_send);// 전송버튼
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);// 메세지화면
        con.add(scrollPane);
        scrollPane.setOpaque(true);
        setTitle("바나나챗");
        setSize(400, 600);
        this.setLayout(new BorderLayout());
        this.add(jp_south, BorderLayout.SOUTH);
        this.add(jp_north, BorderLayout.NORTH);
        this.setSize(400, 600);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        BananaChatRoom room = new BananaChatRoom();
        room.initDisplay();
    }

    public void actionPerformed(ActionEvent e) {
        
        Object obj = new Object();
        
                textArea.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    try {
                       String msg = textArea.getText().toString();
                        if (e.getKeyCode() == 10) {
                            jbtn_send.doClick();
                            textArea.append(textField.getText() + "\n");
                        }
                    } catch (Exception ee) {
                    }
                }
            });

            if (obj == jbtn_back) {
                dispose();// 되돌아가기는 종료다
            }
            if (obj == jbtn_send) {
            try {
                String msg = textArea.getText();
               msg = textArea.getText().toString();
                jbtn_send.doClick();
                textArea.append(textField.getText() + "\n");

            } catch (Exception ee) {
            }
            }
        }
    

    @Override
    public void run() {
        // TODO Auto-generated method stub

    }

}
