package dev_java.waek3.quiz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JButtonUIEvent implements ActionListener{
    JButtonUI jUi= null;
 
    public JButtonUIEvent(JButtonUI jButtonUI) {
        this.jUi =jButtonUI;
    }//전변             지변
    //this O            this X

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == jUi.jbtn_south) {
            System.out.println(jUi.jbtn_south.getText() + "버튼클릭");
        }
    }
    
}
