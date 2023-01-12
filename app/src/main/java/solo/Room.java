package solo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
public class Room extends JFrame {
    JTextArea textArea = new JTextArea(15,38);
    JTextField textField= new JTextField();
    JButton jbtn_send  = new JButton("전송");
    PrintWriter out;
    Socket socket= new Socket();
    JScrollPane jsp_display = new JScrollPane
			(textArea
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    public Room() {
        super("채팅");
        // Text area for displaying received messages
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        // Text field for entering message to send
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                out.println(textField.getText());
                textField.setText("");
            }
        });
        add(textField, BorderLayout.SOUTH);
        // Connect to the server
        try {
            socket = new Socket("192.168.10.78", 9995);
            out = new PrintWriter(socket.getOutputStream(), true);
            new ChatClientThread(socket, textArea).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setVisible(true);
    }
    public static void main(String[] args) {
        Room client = new Room();
    }
}
class ChatClientThread extends Thread {
        Socket socket;
        JTextArea textArea;
        BufferedReader in;
    public ChatClientThread(Socket socket, JTextArea textArea) {
        this.socket = socket;
        this.textArea = textArea;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run() {
        try {
            while (true) {
                String message = in.readLine();
                textArea.append(message + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}