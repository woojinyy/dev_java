package dev_java.weak2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberValidCheck {
    @ParameterizedTest
    //@ValueSource(strings = {"5","1","-10"})터짐
    //@ValueSource(strings = {"5","안녕,"-10"})터짐
    @ValueSource(strings = {"115","111","110"})
    @DisplayName("입력받은 값 유효성 체크하기")
    void 너정수니(String input){
        assertTrue(isNumber(input));
        assertTrue(자릿수체크(input));
    }
    public static boolean 자릿수체크(String s){
        boolean isOk=false;//boolean 디폴트 값은 false
        if(s.length()==3){
            isOk=true;
            return isOk;
        }else{
            return isOk;
        }
    }
    public static boolean isNumber(String s){
        try{
            Double.parseDouble(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
