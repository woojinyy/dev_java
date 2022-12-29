package dev_java.weak4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;

public class VectorCRUDlectrue {

    static Vector<String[]> vdept = new Vector<>();// 스테틱 인스턴스화를 하지않는다 원본을 공유한다.
    static Vector<DeptVO> vdept2 = new Vector<>();

    public void getDeptList() {
        String []copy=new String[3];
        for (int i = 0; i < vdept.size(); i++) {
            for (int j = 0; j <copy.length ; j++) {
                vdept.get(i);
                System.out.println(copy[j]+",");
            }//end of inner
        }//end of outter
    }

    // 조회결과가 벡터에 담긴다 이 벡터가 전역변수 이므로 유지된다.
    // 벡터에 부서정보 추가 무-> 유
    // pass by value로 호출하는 경우 주소번지를 받아옴 -원본을 받는다main.ival, suv.ival
    public int deptInsert(String[] userDept) {// 파라미터 맞춰라, 지역변수로 넘어왔다.

        System.out.println("부서 정보 입력 호출");
        int result = 0;
        boolean isOk = vdept.add(userDept);
        if (isOk) 
            result = 1;// 1이면 성공 0이면 실패
        return result;
    }
    /***********************************************************
     * 벡터에 부서정보 수정하기-있는 거를 변경함                                         *
    @param deptno 수정하고자 하는 부서번호                                            *
    @param user_dname 수정하고자 하는 부서명                                      *
    @param user_loc 수정하고자 하는 지역                                                *
    @return 1이면 성공0이면 수정실패                                                       *
**************************************************************/
    // 벡터에 부서정보 수정 유->변경
    public int deptUpdate(int deptno,String user,String user_dname,String user_loc) {
        System.out.println("부서 정보 수정 호출"+user_dname+","+user_loc);
        String[] oneRow = null;
        String[] comRow = null;
        for(int i=0;i<vdept.size();i++){
            comRow = vdept.get(i);
            if(deptno==Integer.parseInt(comRow[0])){
                //깊은복사  -알빠노
                oneRow = comRow;//얕은 복사 - 하나를 바꾸면 나도 바뀜
            }
        }
        int result=0;
        for(int i =0;i<vdept.size();i++){
            String row[]=vdept.get(i);//i는 로우 인덱스
            //if() 여기는 벡터에서 꺼낸 배열을 갖는다
            for(int j=0;j<row.length;j++){//String[]돌림
                //if ()여기는 화면에서 가져온 배열과 벡터에서 꺼낸 배열 비교
                if(oneRow[0].equals(row[0])){
                    String[]updRow = {oneRow[0],user_dname,user_loc};
                    vdept.remove(i);
                    vdept.add(i, updRow);
                    break;
                }else{
                    System.out.println("선택한 부서번호와 벡터에서 가져온 부서번호가 다르다.");
                }
            }
        }
return 0;
        }
        int result = 0;// 1이면 성공 0이면 실패

    // 벡터에 부서정보 삭제 유->무
    // 벡터에 있는 부서 정보 중에서 어떤 로우를 삭제할 건지 부서번호를 받아와야함 (aka 식별자)
    // 사용자로부터 받아오는데 int형 저장은 String[]에서 String타입 서로 맞지 않아
    // 형 전환이 필요함 null오면 numberformatException 발생할 가능성있어서
    // 앙어 코드 작성 필요 null에 대한 이슈는 현재 프로그래밍에 있어 심각한 장애로 인식
    public int deptDelete(int deptno) {//스캐너를 통해 받아온 값
        System.out.println("부서 정보 삭제 호출");
        int result = 0;// 1이면 성공 0이면 실패
        for (int i = 0; i < vdept.size(); i++) {//벡터 사이즈는 2개
            String oneRow[] = vdept.get(i);
            int deptno2 = 0;
            // 예외 발생에 대한 우려 방어코드 작성
            if (oneRow[0] != null) {// null 체크하였다 null값은 숫자로 못바꾸잖아
                deptno2 = Integer.parseInt(oneRow[0]);
            }
            // 사용자가 선택한 부서번호와 벡터에 있는 부서번호를 비교하여 같은 것 찾기
            System.out.println("입력받은 값과 벡터에서 가져온 값 비교하기"+deptno+","+deptno2);
            if (deptno == deptno2) {//deptno2에는 벡터에 담긴 값
                // 삭제할 벡터의 로우값 필요 -> 벡터의 size로 찾는다
                // remove메소드의 파라미터가 int 인경우에 대해서만 삭제된 벡터의 제네릭
                // 반환해줌 그것을 받아서 처리 여부 확인 가능
                String[] deleteRow = vdept.remove(i);
                // boolean isOk = vdept.remove(oneRow);//메소드 오버 로딩이라 한다.
                // 삭제 한 객체가 존재하니? 네 삭제됨/ 아니오 삭제 안 됨
                System.out.println("삭제된 배열"+Arrays.toString(deleteRow));
                if (deleteRow != null) {// 삭제된 개체가 deleteRow에 담겨있기 때문에
                    //JOptionPane.showMessageDialog(null, "삭제처리되었습니다.");
                    // 삭제 처리가 성공한 경우 반환값 1리턴 끝
                    result = 1;
                }
            }
        }
        return result;
    }

    // 벡터에 부서정보 상세보기 유-> 꺼내기
    public String[] deptDetail(int index) { // 파라미터로 몇번째 값인지 받아
        String[] oneRow = new String[3];
        for (int i = 0; i < vdept.size(); i++) {
            if (1 == 1) {
            }
        }
        return oneRow;
    }

    public static void main(String[] args) {
        VectorCRUDlectrue vCrud = new VectorCRUDlectrue();
        // 입력테스트
        // int deptno = 10;
        // String dname = "개발부";
        // String loc = "인천";
        String[] oneRow = { "10", "개발부", "인천" };// 제네릭타입으로 사용할거야
        int result1 = vCrud.deptInsert(oneRow);
        String[] oneRow2 = { "20", "인사부", "서울" };
        result1 = vCrud.deptInsert(oneRow2);

        if (result1 == 1) {
            JOptionPane.showMessageDialog(null, "등록이 되었습니다.");
            vCrud.getDeptList();
            System.out.print( vCrud);
            //return;// 조건문 안에 return문은 해당 메소드 블럭out (반복문은 break) 주석처리 안하면 아래 문장 실행이 안된다.
            // 메소드 오버로딩
        }
        
        
        Scanner s = new Scanner(System.in);
        System.out.print("수정할 부서번호|부서명|지역을 입력하세요");
        String user =s.nextLine();//10 | 인사부 |포항
        int user_deptno = 0;
        String user_dname=null;
        String user_loc=null;
        StringTokenizer st=new StringTokenizer(user,"|");
        user_deptno=Integer.parseInt(st.nextToken());//사용자가 입력한 부서번호
        user_dname=st.nextToken();//입력한 부서명
        user_loc=st.nextToken();//입력한 지역명
        // 삭제 테스트
        int result3=vCrud.deptDelete(user_deptno);
        if (result3 == 1) {
            JOptionPane.showMessageDialog(null, "삭제되었습니다.");
           //return;
        }
        s.close();
        // 수정테스트
        int result2 =vCrud.deptUpdate(user_deptno,user,user_dname,user_loc);
        // 상세보기 테스트
        String[] result4 = vCrud.deptDetail(user_deptno);
    }// end of main
}//
