package dev_java.bookMVC;

public interface Controller {
    public abstract FrontController getController(String gubun);
    //인터페이스 : 단독으로 인스턴스화 X ,구현체메소드 필요
//                          생성자X  implements쓴다 추상메서드만 갖는다
//                      일반 메서드 X 일반 전변X
  //추상클래스 생성자 갖는다, 추상메서드 일반메서드 O 
}
