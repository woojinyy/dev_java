package dev_java.network2;

import java.util.StringTokenizer;
import java.util.Vector;

public class TalkClientThread extends Thread {
    TalkClient tc = null;

    public TalkClientThread(TalkClient tc) {
        this.tc = tc;
    }
    

    // 서버쪽에서 클라이언트가 접속하면 접속자의 정보를 List<TalkServerThread>에 add(스레드생성자)했고
    // 메세지를 듣자마자 클라이언트측에 반복문을 돌려서 쓰기한다(전송)-broadCastring(String msg)
    //
    @Override
    public void run() {
        boolean isStop = false;// 너 나가
        // run_stop://라벨붙이기
        while (!isStop) {
            try {
                // 100#tomato 컨셉으로 들어온다 뒤에 "님 입장하였습니다."붙여주고 싶어
                String msg = "";
                msg = (String) tc.ois.readObject();// 듣기e 오브젝트를 스트링으로 형전환해줘야해
                System.out.println("서버에서 전송된 msg"+msg);
                StringTokenizer st = null;
                int protocol = 0;// 100 입장 200 다자간 대화 300 1:1대화 400 대화명변경 500 나가기받아서 switch문으로 바꿔준다
                if (msg != null) {
                    st = new StringTokenizer(msg, "#");
                    protocol = Integer.parseInt(st.nextToken());
                }
                System.out.println("protocol"+protocol);
                switch (protocol) {// 프로토콜 기준
                    case Protocol.TALK_IN: {
                        String nickName = st.nextToken();
                        tc.jta_display.append(nickName + "님이 입장하였습니다.\n");
                        // jtable은 양식일 뿐이고 데이터셋은 DefaultTable이니까 거기에 닉네임을 출력
                        Vector<String> v = new Vector<>();
                        v.add(nickName);//대화명에 아이디 추가
                        // 데이터셋객체에 한 개로우 추가하기
                        tc.dtm.addRow(v);// 대화명 넣을 열 추가
                      
                    
                    }
                        break;
                        default:
                        System.out.println("해당하는 프로토콜이 존재하지 않습니다.");
                }
            } catch (Exception e) {
            e.printStackTrace();
            }

        }

    }

}
