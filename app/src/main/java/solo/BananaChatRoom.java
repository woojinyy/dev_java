package solo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BananaChatRoom extends JFrame implements ActionListener {
    //선언부
    
    JTextField textField;
    JTextArea textArea;
    JPanel jp_second	  = new JPanel();
	JPanel jp_second_south = new JPanel();
    JPanel panel = new JPanel();
    JButton jbtn_send  = new JButton("전송");

    public  BananaChatRoom() {
        
        setTitle("Chat Messenger");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textField = new JTextField(30);
        jp_second_south.add("East",jbtn_send);
        textField.addActionListener(this);
        panel.add(textField);
        add(panel, "South");
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, "Center");
    }

    public static void main(String[] args) {
        BananaChatRoom messenger = new  BananaChatRoom();
        messenger.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String message = textField.getText();
        textArea.append(message + "\n");
        textField.setText("");
    }
}