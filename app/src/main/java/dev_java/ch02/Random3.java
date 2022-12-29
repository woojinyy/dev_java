package dev_java.ch02;

import java.util.Random;
import java.util.Scanner;

public class Random3 {
    public static void main(String[] args) {

        Random r = new Random();

        Scanner scanner = new Scanner(System.in);

        int com = r.nextInt(10);// 0~9 중 난수하나를 임의선택
        System.out.println("채번한 숫자는=" + com);
        int my = 0;// 내가 입력할 수 초기화
        int cnt = 4;
        boolean isOK = true;
        while (isOK) {

            System.out.println("0부터 9사이의 정수를 입력해");

            my = scanner.nextInt();
            if (cnt == 0) {
                System.out.println("5번 다 씀 ㅂㅂ");
                System.exit(0);// 파라미터에 0을주면 JVM과 연결고리 끊김
                // =종료=할당 스레드 반환
            }

            System.out.println("사용자가 입력한 값" + my);
            if (com == my) {

                System.out.println("ㅊㅋ");
                System.out.println(cnt);
                scanner.close();

                break;
            } else if (com > my) {
                System.out.println("up");// 난수가 입력한 값보다 크면 > up
                System.out.println("남은 기회" + cnt--);
            } else if (com < my) {
                System.out.println("down");// 난수가 입력한 값보다 작으면 >down
                System.out.println("남은 기회" + cnt--);
            } else if (my == 100) {
                System.exit(0);// 연결고리 끊어 빠져나갈래5
            }

        }

    }
}
