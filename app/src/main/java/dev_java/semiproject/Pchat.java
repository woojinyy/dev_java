package dev_java.semiproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class Pchat extends JFrame implements KeyListener {
    String imgPath = "D:\\vscod_java\\dev_java\\app\\bin\\main\\dev_java\\images\\bananaproject\\";
    ImageIcon iicon = new ImageIcon(imgPath + "bananaPchat.png");
    Container con = this.getContentPane();

    public Pchat() {
        // setUndecorated(true);
        // AWTUtilities.setWindowOpaque(this, false);
        // this.setContentPane(mp);
        final JTextPane textPane = new JTextPane();
        textPane.setOpaque(false);
        JScrollPane jsp = new JScrollPane();
        JTextArea jta= new JTextArea();
        JTextField jtf_messageField = new JTextField();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(jtf_messageField);
        frame.setSize(300, 100);
        frame.setVisible(true);

       jtf_messageField.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                String message = jtf_messageField .getText();
                writer.println(message);
                jtf_messageField .setText("");
            }
        }
    });

        JViewport viewport = new JViewport() {
            @Override
            protected void paintComponent(Graphics g) {
                Image img = iicon.getImage(); //
                // Image grayImage = GrayFilter.createDisabledImage(img);
                setOpaque(false);
                Graphics2D gd = (Graphics2D) g;
                gd.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
                g.drawImage(img, 0, 0, this);
                super.paintComponent(g);
            }
        };
        // viewport.setOpaque(false);
        jsp.setOpaque(true);
        jsp.setViewport(viewport);
        jsp.setViewportView(textPane);

        // mp.add("Center",jsp);
        con.add(jsp);
        // frame.pack();
        this.setSize(350, 600);
        // con.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Pchat();
    }





    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            out.println(jtf_messageField.getText());
        // TODO Auto-generated method stub
        
    }

}

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}