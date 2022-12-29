package dev_java.waek3.quiz2;

import java.util.Scanner;



class Gravity {
    int earth ;
    void scanner() {
        System.out.println("몸무게 입력");
        Scanner s = new Scanner(System.in);
        String user1 = s.nextLine();
        earth = Integer.parseInt(user1);
        double moon=0.17;
        double w = earth * moon;
        System.out.println(earth+"kg");
System.out.println(w+"kg");
    }
   
}

public class GravityMain {

    
    public static void main(String[] args) {
Gravity g=new Gravity();
g.scanner();
    }

}
