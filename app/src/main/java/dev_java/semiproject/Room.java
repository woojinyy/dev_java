package dev_java.semiproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

public class Room extends JFrame implements ActionListener {

    // 채팅창과 관련된 컴포넌트들
    JTextField inputField = new JTextField(30);
    JTextArea chatArea = new JTextArea(10, 30);
    JButton sendButton = new JButton("보내기");

    // 서버와 연결된 소켓
    Socket socket;
    // 소켓을 통해 입력되는 스트림과 출력되는 스트림
    BufferedReader brin;
    PrintWriter prout;

    // 생성자
    public Room() {
        // 채팅창의 기본적인 구성

        inputField.addActionListener(this);
        chatArea.setEditable(false);
        sendButton.addActionListener(this);

        // 채팅창을 위한 패널 생성
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        // 채팅창의 기본 구성과 패널을 프레임에 추가
        this.setLayout(new BorderLayout());
        

        // 프레임 설정
        this.setTitle("바나나");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 600);
        this.setVisible(true);

        // 서버와 연결
        try {
            socket = new Socket("192.168.10.78", 9999);
            brin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            prout = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 서버로부터 전송된 메시지를 수신할 스레드 생성
       // Thread receiver = new Thread(new Receiver());
       // receiver.start();
    }
public static void main(String[] args) {
    
}
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}
