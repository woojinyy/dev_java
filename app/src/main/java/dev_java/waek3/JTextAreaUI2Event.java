package dev_java.waek3;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class JTextAreaUI2Event implements ActionListener {
JTextAreaUI2 jUi2 = null;


public JTextAreaUI2Event(JTextAreaUI2 jUi2){
    this.jUi2 = jUi2;
    
}
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj =e.getSource();
            if (jUi2.jtf == obj) {//엔터내용
                String input = jUi2.jtf.getText();
                jUi2.getTextArea().append("JTextAreaUI원본"+ input +"\n");
                //jUi2.jtaUILogic2.account(input);
                jUi2.jtf.setText("");
            }
    }
    
}
