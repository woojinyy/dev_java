package dev_java.weak4;

class AccessModifier1{
    void  test1(){
        System.out.print("test1출력");
    }
}

public class AccessModifier {
    public void test(){
    System.out.print("test출력");
    }

public static void main(String[] args) {
    AccessModifier am= new AccessModifier();
    am.test();
    AccessModifier1 am2=new AccessModifier1();
    am2.test1();

}
    
}
