package dev_java.ch01;

public class MethodExam {
    void m() {//반환값이 보이드다

    }

    int m1() {
        return 0;
    }

    String getName() {
        String name = "가나다";
        return name;
    }

    boolean done() {
        boolean m3 = true;
        return m3;
    }

    public static void main(String[] args) {
        MethodExam r1 = new MethodExam();
        // int x = r1.m();
        int y = r1.m1();
        // System.out.println(r1.m());
        System.out.println("r1.m1 :" +r1.m1());

    }

}