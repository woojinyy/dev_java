package dev_java.ch01;

public class PrideMain {
    public static void main(String[] args) {
        
    
    Pride myCar= new Pride();
    System.out.println(myCar);
    
    Pride herCar = new Pride();
    System.out.println(herCar);
    
    herCar=myCar; //왼쪽값이 오른쪽값이 된다 -> true
    System.out.println(myCar);
    System.out.println(herCar);
    
    System.out.println(myCar==herCar);//false
}
}
