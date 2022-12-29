package dev_java.ch01;

class Param {
    int ival;// 전역변수  0 ->100 -> 500
    
}

public class TestParam {
    void effectParam(Param p) {// 지역변수
        // insert here -여기에 p= new Param()이 있으면 결과가 달라진다?Y or N
        //p = new Param();
        p.ival = 500;
        
        System.out.println("sub ival===>" + p.ival);
    }

    public static void main(String[] args) {
        TestParam tp = new TestParam();// 인스턴스화
        Param p = new Param(); // 인스턴스화
        p.ival = 100;
        tp.effectParam(p);// 주소번지@abcd1234를 넘긴다
        System.out.println("main ival===>" + p.ival);

    }
}
