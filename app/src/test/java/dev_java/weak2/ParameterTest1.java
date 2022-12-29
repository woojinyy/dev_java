package dev_java.weak2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
    
@DisplayName("파라미터 테스트 활용")
public class ParameterTest1 {
    



@ParameterizedTest
  @ValueSource(ints = { 1, 5 })
    @DisplayName("valuesource를 통해서 ")
    void isPositive(int number) {
        assertTrue(number > 0);
    }

}

    




