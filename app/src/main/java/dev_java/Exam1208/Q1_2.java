package dev_java.Exam1208;



public class Q1_2 {
   

    public static void main(String[] args) {
        Q1_2 cnt = new Q1_2(); // static 안에서 non-static호출하려면 인스화 필요
        String str= null;//초기화 됐다고 생각하면 안돼
        if (str.equals("exit")){//null time exception
    //.NullPointerException: Cannot invoke "String.equals(Object)" because "str" is null

        }

    }
}
