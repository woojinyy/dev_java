package dev_java.waek3.quiz2;

class time {
    int in1, in2 = 0;
    int count = 0;//전역변수 파라미터에 따라 각각 다른값이다 case by case

    int ttt(int in1, int in2) {
        if (in1 < in2) {
            for (; in1 <=in2; in1++) {
                if (in1 % 3 == 0) {
                    count++;
                }
            }
        }else if(in1>in2){
            for (; in2 <= in1; in2++) {
                if (in2  % 3 == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}

public class Counting {
    public static void main(String[] args) {
        time a = new time();
        a.ttt(3, 13);
        System.out.println(a.count);
    }
}
