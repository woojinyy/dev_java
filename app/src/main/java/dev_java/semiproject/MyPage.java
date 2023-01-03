package dev_java.semiproject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPage extends JFrame implements ActionListener{
JPanel jp= new JPanel();
JButton jbtn= new JButton();
    public void initDisplay(){
jbtn.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
