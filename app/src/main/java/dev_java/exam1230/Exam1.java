package dev_java.exam1230;

public class Exam1 {
    
    //내 컴퓨터의 ip 옹라클접속할 때도 접속할 서버의 ip를 써야해
    //inet 클래스 타입 getlocalhost 타입이 왔다는 말은 스테틱타입이기 때문에 보 ㄱ제본을 만드지 않는다
    /*
     * getlocalhost에 .을 붙이면 반환하면 getlocalhost를 호출하는거겠죠
     * 찍히는건 로컬호스트다 127.0.0.1:9000
     * 톰캣 =localhost9000
     * 첫번쨰 파라미터에 serverip  가져오는건 localhost면 서로 맞지 않는다
     * 내가 서버가 아닌데 서버에 접속하려는 것인데 클라이언트쪽에서 서버에 접속하려는 데 접속이 안됐다는거니까
     * 서버에 
     * 포트번호 양쪽이 서로 맞아야 하는데 
     * 서버쪽에는 소켓이 두개 필요
     * 하나는 서버소켓 하나는 소켓
     * Socket 실제 일하는 소켓
     * ServerSocket 동시에 많은 사람이 접속해올 때 뒤지지않고
     * 모두 받아주기 위한 소켓이다
     * 대기상태가 진행된다
     * 뒤에있는 코드는 진행이 안된다
     * wait status
     * 언제 진행하게 되는가?
     * -> client 올 떄까지
     * while문을 썻다면 왜????
     * 객체를 말할 때 의인화 해봐라
     * 클래스를 말할 때도
     * 손님이 들어와 주문할게요 하면
     * 내부에 있는 직원이 와서
     * 밥 줘 밥 줘 밥 줘 해 줘 밥 줘 해 줘 
     * 해 줘 해 줘 해 줘 해 줘 해 줘 해 줘 해 줘
     * 언제까지? 나갈 때까지 
     * 연결고리가 끊길 때까지 
     * 끊기면 candidate 상태
     * 
     * 스피커 (h.w)=소켓 ois(object input stream 소켓과 의존관계이다
     * 마이크(h.w)=소켓 역할을 하기위해  소프트웨어가필요하다 -> oos
     * 서버는 들은 걸 말한다
     * 지속적으로 반복 하려면 thread를 구현해야한다
     * 
     * jtextarea upend 기존에 이어쓰기
     * FileWriter("test.txt") text.txt 
     * 문서파일에 글쓰는 메소드
     * test.txt파일이 없으면  file not found exception
     * File f  = new File("text.txt"); 그냥 오브젝트만들어주기만함 내용관여 x
     * 파일을 오브젝트로 만들어줘야 메소드 호출이 가능
     * 파일만 객체화 해줌 쓰기,삭제 없어
     * FileWriter fw = new FileWriter();
     * File f  = new File("text.txt");
     * 
     * upend 
     */
}
