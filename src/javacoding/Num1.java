package javacoding;

import java.util.Scanner;

public class Num1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double exchange_rate = 1100;

        double krw = scanner.nextDouble();//원화 입력 받기
        System.out.println("Input KRW >> " + krw);

        //원화를 달러로 변환
        double usd = krw / exchange_rate;

        System.out.printf("%.0f krw is %.0f usd", krw, usd);

        scanner.close();
    }
}
