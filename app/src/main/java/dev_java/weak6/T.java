package dev_java.weak6;

public class T {
    ZipCodeSearch zcs= null;
    //메소드를 통해서도 객체주입을 받을 수 있다.-싱글톤패턴
    public ZipCodeSearch getInstance(){
        //메소드로 객체주입받기
        if(zcs==null){//조건부로  null일때만
            zcs= new ZipCodeSearch();
        }
        return zcs;//메소드를 통해서 객체주입받기 가능하다 싱글턴
    }
    public static void main(String[] args) {
        T t= new T();
        t.zcs=t.getInstance();//친해지길바라
        t.zcs.getZipcode("역삼동");
        
    }
}
