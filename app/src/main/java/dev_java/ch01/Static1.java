package dev_java.ch01;

public class Static1 {
    static{//우선순위가 main method보다 높다
        System.out.println("Static 블록호출");
        //main method를 호출 했을 때만 출력된다
        
    }
    //main thread라고 한다.
    //main 은 entry point 이다
    //main은 개발자가 호출하는 method가 아니다.
    //시스템이 자동으로 호출해준다 =callback method
    // main method에 코딩하는 것은 옳바른 방향은 아니다.= 응애 해 줘
    //main method에 작성한 코드는 재사용성이 없다.
    //class 안에 main method는 없어도 된다. 단, 실행은 안된다.
    public static void main(String[] args) {
        System.out.println("main호출");
    }
}
