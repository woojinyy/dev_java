package dev_java.weak2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RepeatedTest1 {
    @Test//test 메소드당
    @DisplayName("파라미터 두 수 비교 테스트")
    void methodB(){
        assertEquals(2, 1+2);

    }
    @RepeatedTest(5)//annotaition 반복테스트를 위해 사용되는
    void methodA(){
        Random r =new Random();
        int i= r.nextInt(10);
        System.out.println(i);
    }
}
