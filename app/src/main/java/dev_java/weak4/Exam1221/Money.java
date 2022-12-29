package dev_java.weak4.Exam1221;

public class Money {
    public static final String UNIT ="원";
    public int money;
    public Money(){
        //전역변수의 초기화  
    }
    public Money(int money){
        //초기값= 파라미터값
        this.money =money;
    }
    public void pay(int money) {
        this.money = this.money-money;
        
    }
    private int getMoney(){
        return money;
    }
    void setMoney(int money){
        this.money = money;
        System.out.println(money);
    }
    private static String getUnit() {
        return UNIT;
    }
    public void print(){
        System.out.println(money+UNIT+"이 있습니다.");
    }
    
}
