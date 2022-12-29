/*package dev_java.ch01;

public class MemberAction2 {// 회원가입을 생각해보자 성공하면 1을반환 실패하면 0을 반환
    // Q. 반환타입은?
    
    public int memberinsert(String mem_id, String mem_name, String mem_pw) {
        System.out.println("memberinsert 호출-파라미터 3개");
        System.out.println(mem_id+","+mem_pw+","+mem_name);
        int result = -1;
        //회원가입에 성공했니?
        if(1==1){
            result=1;
        }else{
            
        }
        MemberVO memberVO= new MemberVO();
        memberVO.setMem_id("tomato");
        memberVO.setMem_name("토마토");
        memberVO.setMem_pw("456");
       int result2= memberAction2.memberinsert(memberVO);

        return result;

    }

    public int memberinsert(MemberVO memberVO) {
       

        System.out.println("memberinsert 호출-파라미터 1개");
        System.out.println(memberVO.getMem_id()+","+memberVO.getMem_pw()+","+memberVO.getMem_name());
        int result = -1; // End of File 찾았는데 없으면 끝
        result=1;
        return result;
    }

    public static void main(String[] args) {
        MemberActioin2 memberAction = new MemberAction2();
        int result = memberAction.memberinsert(mem_id:"apple",mem_pw: "123", mem_name: "사과");

        }

    }

*/
