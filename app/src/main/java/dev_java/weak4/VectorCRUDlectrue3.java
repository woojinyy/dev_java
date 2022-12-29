package dev_java.weak4;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;

public class VectorCRUDlectrue3 {// 배열 버리고 벡터로 바꾸자

    static Vector<DeptVO> vdept = new Vector<>();
    static Scanner s=new Scanner(System.in);
    public void getDeptList() {
        for (int i = 0; i < vdept.size(); i++) {
            DeptVO dVO = vdept.get(i);
            System.out.print(dVO.getDeptno() + ", " + dVO.getDname() + "," + dVO.getLoc());
        } 
    }
    public int deptInsert(DeptVO pdVO) {
        System.out.println("부서 정보 입력 호출");
        int result1 = 0;// 1이면 성공, 0이면 실패
        boolean isOk = vdept.add(pdVO);
        if (isOk)
            result1 = 1;
        return result1;
    }
    public int deptUpdate(DeptVO pdVO) {//pdVO에는 부서번호만 있다. 
        System.out.println("deptUpdate호출 : 입력받은 부서번호는"+pdVO.getDeptno());//수정할 번호입력받은걸 가져온다
        int result2 =0;
        System.out.print("수정할 부서번호,부서명, 지역를 입력하세요.(구분은|연산자로 함)");
        //Scanner s1= new Scanner(System.in);//사용자 입력 정보 인식
        VectorCRUDlectrue3.s=null;
        VectorCRUDlectrue3.s= new Scanner(System.in);
		String user = VectorCRUDlectrue3.s.next();//10|인사부|포항 로 입력
		int user_deptno = 0;//사용자가 입력한 부서번호 담을 변수
		String user_dname = null;// 사용자가 입력한 부서명 담을 변수
		String user_loc = null;//사용자가 입력할 지역 담을 변수
		StringTokenizer st = new StringTokenizer(user, "|");//문자열 동시에 받아오려고 String Tokenizer사용 메신저 사용할 때 쓸거다 기억해놔라
		user_deptno = Integer.parseInt(st.nextToken());//사용자가 입력한 부서번호
		user_dname = st.nextToken();//사용자가 입력한 부서명
		user_loc = st.nextToken();//사용자가 입력한 지역
        //사용자가 입력한 부서번호 | 부서명 | 지역 을 DeptVO의 멤버변수에 초기화
        DeptVO updVO=DeptVO.builder().deptno(user_deptno).dname(user_dname).loc(user_loc).build(); //사용자로부터 입력받은 수정할정보(10 인사부 포항)로 초기화
        //벡터에 들어있는 DeptVO에서 꺼낸 부서번호와 파라미터로 넘겨받은 부서번호가 같으면 DeptVO에 인덱스가 우리가 삭제하고 추가해야하는 벡터의 인덱스값이 된다
        DeptVO comVO=null;
        for(int i =0; i< vdept.size();i++){
            comVO = vdept.get(i);//화면에서 받아온 DeptVO의 deptno와 벡터안에서 꺼내온 DeptVO의deptno같니?
            if(updVO.getDeptno()==comVO.getDeptno()){//화면에서 받아온 부서번호와 벡터에서 꺼낸 부서번호가 같을 때의 i값
                vdept.remove(i);
                vdept.add(i,updVO);
                result2 = 1;
                break;//벡터 반복하는 for문 탈출
            }
            // else{
            //     System.out.println("선택한 부서번호와 벡터에서 가져온 부서번호가 다르다.");
            // }
            //getDeptList();//새로고침 처리됨
        }
        return result2;
    }////
    public int deptDelete(int deptno){
        System.out.println("부서 정보 삭제 호출");
        int result =0;
        for(int i=0;i<vdept.size();i++){
            DeptVO readVO = vdept.get(i);//벡터에서 꺼낸 값
            int deptno2=0;
            deptno2=readVO.getDeptno();//벡터에서 꺼낸값으로 초기화
            System.out.println("입력받은 부서번호 : "+deptno+" 벡터에서 꺼낸값 : "+deptno2);
            if(deptno==deptno2){
            DeptVO removeVO=vdept.remove(i);
            if(removeVO !=null)result =1;
            }
        }
        return result;
    }
    

    public DeptVO deptDetail(int deptno) {
        DeptVO rdVO = null;
        System.out.println("상세보기 호출");
        for(int i=0; i<vdept.size();i++){
        }
        return rdVO;
    }

    public static void main(String[] args) {
        VectorCRUDlectrue3 vCrud = new VectorCRUDlectrue3();
        // 입력테스트
        DeptVO dvo1 = DeptVO.builder().deptno(10).dname("개발부").loc("인천").build();
        System.out.println(dvo1.toString());
        // dvo1의 주소번지와
        int result1 = vCrud.deptInsert(dvo1);// 1차스트링 배열에서 벡터로 바뀌었다 메소드오버로딩 규칙에 따라 같은 타입이 들어가야한다.
        dvo1 = null;
        dvo1 = DeptVO.builder().dname("총무부").deptno(20).loc("서울").build();
        System.out.println(dvo1.toString());
        result1 = vCrud.deptInsert(dvo1);
        // dvo1의 주소번지가 다르다

        if (result1 == 1) {
            JOptionPane.showMessageDialog(null, "등록이 되었습니다.");
            vCrud.getDeptList();
            // return;//조건문안에 return문 해당 메소드 블록을 빠져나간다.
        }
        // 수정 테스트
        //Scanner s = new Scanner(System.in);
        //수정과 삭제 메뉴 선택 담기
        int result2=0;//수정성공여부담기 1이면 성공 0이면 실패
        int choice =0; //디폴트
        System.out.print("수정은 1 삭제는 2 를 입력");
        choice = VectorCRUDlectrue3.s.nextInt();//입력받은 숫자 담긴다
        if(choice==1){//1이면true이면 아래코드 실행
            System.out.println("수정하고자 하는 부서번호 입력 : ");//수정할 부서번호 입력 
            int u_deptno=s.nextInt();//입력받은 부서번호 담긴다
            //담을 수 있는 값은 부서번호 뿐이다 Q. dname,loc에는 뭐가 들어있냐? A.null , null 
            DeptVO updVO=DeptVO.builder().deptno(u_deptno).build();
            result2=vCrud.deptUpdate(updVO);//DeptVO를 파라미터로 넘긴다 메인메소드에서 결정된 정보 현재는 부서번호만
            if(result2==1){//
                System.out.println("수정 되었습니다.");
                vCrud.getDeptList();//목록조회
            }
            else System.out.println("수정실패");
        }
        else if(choice==2){
            //vCrud.deptUpdate(dvo1);
        }
        //삭제 테스트
        System.out.println("삭제하고자 하는 부서번호 입력");
        int del_deptno= VectorCRUDlectrue3.s.nextInt();
        int result3 =vCrud.deptDelete(del_deptno);//내안에 없으니까 
        if(result3==1){
            System.out.println("삭제되었습니다.");
            vCrud.getDeptList();
        }
        else{
            System.out.println("삭제 실패");
        }
        VectorCRUDlectrue3.s.close();
        // 상세보기 테스트
    }// end of main
}
