package javacoding;

import java.util.Scanner;

public class Num5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input integer (1 ~ 99)");
        int num = sc.nextInt();

        //입력 받은 정수를 문자열로 변환
        String number = Integer.toString(num);
        int clapcount = 0;

        for(int i = 0; i < number.length(); i++) {
            //문자열에서 특정 위치에 있는 문자를 반환
            char c = number.charAt(i);
            if(c == '3' || c == '6' || c == '9'){
                clapcount++;
            }
        }

        for(int i = 0; i < clapcount; i++) {
            System.out.print("clap ");
        }
        sc.close();
    }
}
