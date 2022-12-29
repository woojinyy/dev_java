package dev_java.weak4.Exam1221;

public class Run {
    public static void main(String[] args) {
        Money m = new Money(1000);//엄마한테 들어갈 돈
        //잔액 1000
        m.setMoney(10000);
        //잔액 10000
        m.pay(3000);
        System.out.println(m.money);
        m.print();

    }

}
