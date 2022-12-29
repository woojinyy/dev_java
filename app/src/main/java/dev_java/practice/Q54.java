package dev_java.practice;

public class Q54 {
    public void testifA(){
        if(testifB("true")){
            System.out.println("true");
        }
        else{
            System.out.println("Not true");
        }
    }
    public Boolean testifB(String str){
        return Boolean.valueOf(str);
    }
    public static void main(String[] args) {
        Q54 q= new Q54();
        q.testifA();
    }
}
