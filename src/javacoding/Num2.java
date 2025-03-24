package javacoding;

import java.util.Scanner;

public class Num2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        System.out.println("Input 2-digit number(10 ~ 99) >>" + num1);

        //10의 자리와 1의 자리 수가 같은지 확인
        //1의 자리와 10의 자리의 수를 추출을 먼저 한다
        int one = num1 % 10;
        int two = num1 / 10;

        if(one == two){
            System.out.println("Yes! The digit of 10 and the digit of 1 are the same.");
        }else {
            System.out.println("No! The digit of 10 and the digit of 1 are the different.");
        }
        sc.close();
    }
}
