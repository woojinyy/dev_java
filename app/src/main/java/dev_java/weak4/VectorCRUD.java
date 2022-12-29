package dev_java.weak4;

import java.util.Vector;

public class VectorCRUD {
    static Vector<String[]> vdept = new Vector<>();
    
    
    //벡터에 부서정보 추가 무-> 유
public int deptInsert(String[] deptins){

    System.out.println("부서 정보 입력 호출");
    
    int result=0;
    boolean isOk=vdept.add(deptins);
    if(isOk){
    result = 1;//1이면 성공 0이면 실패
    }
    System.out.println(result);
    return result;
}
    //벡터에 부서정보 수정 유->변경
    public int deptUdate(int deptno, String[] oneRow){
        System.out.println("부서 정보 수정 호출");
        String copyname[]=new String[3];
        for(int i=0; i<vdept.size();i++){
            copyname=vdept.get(i);
            Integer.toString(deptno);
        {
        }
     
            
        }
        
        int result = 0;//1이면 성공 0이면 실패
        
        return result;
    
    }
    //벡터에 부서정보 삭제 유->무
    public int deptDelete(){
        System.out.println("부서 정보 삭제 호출");
        vdept.remove(1);
        int result = 0;//1이면 성공 0이면 실패
        return result;
    
    }
    //벡터에 부서정보 상세보기 유-> 꺼내기
    public String[] deptDetail(int index){ //파라미터로 몇번째 값인지 받아
       String[] oneRow = new String[3];
       for(int i =0;i<vdept.size();i++){
       // if(){

      //  }

       }
       return oneRow;
    }
    public static void main(String[] args) {
        VectorCRUD vCrud = new VectorCRUD();
        //입력테스트
        int deptno = 10;
        String dname = "개발부";
        String loc = "인천";
        String[] oneRow={"10","개발부","인천"};
        int result1=vCrud.deptInsert(oneRow);
        vCrud.deptInsert(oneRow);
        //수정테스트

        //삭제 테스트

        //상세보기 테스트
        
    }//end of main
}//
