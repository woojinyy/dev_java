package dev_java.bookMVC;

public class FrontController {
    public static Object getController(String gubun){
        //public static FrontController getController(String gubun){
        Object obj = null;
        //BookController,BoardController
       //FrontController obj=null;
        if("bookMgr".equals(gubun)){
            obj= new BookController();
        }else if("boardMgr".equals(gubun)){
            obj=new BoardController();
        }
        //왜 리턴타입을 obj????????????????????????
        //bookcotroller 일수도 boardcontroller일수도 있어서 
        //둘다 포용가능한 오브젝트
        return obj;
     
    }
}


