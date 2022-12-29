package dev_java.network2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class TalkServerThread extends Thread{
    TalkServer ts =null;
    Socket client=null;
    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    //현재 서버에 입장한 클라이언트 스레드의 닉네임 저장
    String chatName=null;
    //생성자
    public TalkServerThread(){ 

    }
    public TalkServerThread(TalkServer ts) {
        this.ts =ts;
        this.client=ts.socket;
        try {
            oos=new ObjectOutputStream(client.getOutputStream());//말하기
            ois=new ObjectInputStream(client.getInputStream());//듣기
            String msg =(String)ois.readObject();
            ts.jta_log.append(msg+"\n");
            StringTokenizer st = new StringTokenizer(msg,"#");
            st.nextToken();//100skip처리
            chatName =st.nextToken();//토마토 저장
            ts.jta_log.append(chatName+"님이 입장하였습니다.\n");
        //-----------------------------------------------------
            for(TalkServerThread tst:ts.globalList){
                this.send(Protocol.TALK_IN+Protocol.separator+tst.chatName);
            }//this와45의 tst의 차이
            //현재 서버에 입장한 클리아언트에 스레드 추가하기
            ts.globalList.add(this);//이 this는 뭔가요? 없으면 메세지 전달이 안 돼  
            this.broadCastring(msg);
        //-------------------------------------------------------
        } catch (Exception e) {
        }
    }
    //현재 입장해 있는 친구들 모두에게 메세지 보내기구현
public void broadCastring(String msg){
    for(TalkServerThread tst:ts.globalList){
        tst.send(msg);//tst의 차이는?????34번this와

    }
}
//클라이언트에게 말하기 구현
public void send(String msg){
    try {
        oos.writeObject(msg);
        
    } catch (Exception e) {
        e.printStackTrace();//stack에 쌓여있는 에러메세지
        //디버깅할 때 유익하다
    }

    
}
@Override
public void run(){
    
}
}
