package dev_java.ch01;

public class P21_3 {
    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        if ((i != --j) & (++i <= j)) {// 참참 일때만 참 거참 거 참거 거 거거 거 즉 하나라도 거짓이면 거짓
            // & 앞조건이 false이더라도 검사 해야 해
            // 앞 조건이 T j=1=i이니까 뒷실행문도 따져
            // 뒷조건 F -> else문으로 가자
            System.out.println("조건을 만족할 때");
            // Q. i와 j값을 확인할 수 있나???? A. 이 안에서는 확인 X

        } else {
            System.out.println("조건을 만족하지 않았을 때");

        }
        System.out.println("i=" + i + "j=" + j);
    }
}
