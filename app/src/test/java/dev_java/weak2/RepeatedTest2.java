package dev_java.weak2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RepeatedTest2 {
    @DisplayName("0부터9사이 골라")
    @RepeatedTest(10)
    void methodA(){
        int com =(int)(Math.random()*10);
    }
}
