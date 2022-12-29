package dev_java.ch01;

public class MemberVOMain {
    public static void main(String[] args) {
        MemberVO memberVO = new MemberVO();
        String 사용자가입력한아이디 = "apple";
        System.out.println(사용자가입력한아이디);
        // memberVO클래스에서 mem_id는 접근제한자를 private으로 했으므로
        // 외부에서 접근이 불가 하다
        // 따라서 setter method를 제공하고 있다.
        // Q.어떻게한다?
        // String mem_id=memberVO.setMem_id("tomato");//A.직접접근 불가하다 private이기때문에
        // setter method 의 반환형은 void라 대입연산자 = 사용할 수 없다.
        // memberVO.mem_id="tomato";//불가 Q.왜? A.praivate이니까
        memberVO.setMem_id("tomato");
        // System.out.println(memberVO.mem_id);//praivate 으로 선언된 변수는 클래스외부에서
        // 사용불가-encapsulation ,보안
        String mem_id = memberVO.getMem_id();
        String id = memberVO.getMem_id();
        System.out.println(id);
        System.out.println(mem_id);

        // memberVO.mem_name="토마토";//Q.초기화 어쾀? A.mem_name의 경우 접근제한자를 public으로 했으므오 직접
        // 초기화가 가능하다. 전역변수에 직접 초기화
        // String name=memberVO.mem_name;//null
        // System.out.println(name);
        // System.out.println(memberVO.mem_name);
        memberVO.setMem_name("이순신");// setter method호출하는것 만으로 초기화된다.
        System.out.println(memberVO.getMem_name());
        memberVO.setMem_pw("123");// getter method를 호출하면 전역변수인 mem_pw에 저장된 값이 출력됨
        // setter method를 호출하지 않고 getter method를 호출하면 초기화된 값이 존재하지 않으므로null이 출력될것임
        System.out.println(memberVO.getMem_pw());

    }
}
