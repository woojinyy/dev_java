package dev_java.ch01;

//자료구조의 일부로 사용한다
public class MemberVO {// data set이라main method필요없다
    // 회원정보를 관리하기 위한 목적
    private String mem_id = null;
    private String mem_pw = null;
    private String mem_name = null;

    public void setMem_id(String mem_id) {// Q.무엇을쓸거니? A.지역변수 id
        this.mem_id = mem_id;// this() =memberVO자신,전역변수) 지역변수를 받아서 전역변수에 초기화
        // Q그럼 encapsulation한거는 어떻게 씀?
        // A get으로 read
        // set으로 write Q.파라미터= 무엇을 담을거니? A. String 타입으로 id를 저장
        // void 반환값은 =로 받을 수 없다
    }
    

    public String getMem_id() {
        return mem_id;
    }


    public String getMem_pw() {
        return this.mem_pw;
    }

    public void setMem_pw(String mem_pw) {
        this.mem_pw = mem_pw;
    }

    public String getMem_name() {
        return this.mem_name;
    }

    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }
    //  전역변수 idprivate이면 인스턴스화 안하고 못쓴다
    // private으로 보안성 올린다.
    // Q그럼 어케씀?
    // A 캡슐화 한다 encapsulation(객체가 기능을 어떻게 구현 했는지 외부에 감추는 것)



    public static void main(String[] args) {
        MemberVO memberVO = new MemberVO();
        System.out.println(memberVO.mem_name);// null
    }

}
