package javacoding;

import java.util.Scanner;

public class Num12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input a lowercase alphabet >>");
        char input = sc.next().charAt(0);//scanner 클래스에서 한 글자를 입력받기 위함

        for(char start = input; start >= 'a'; start--) {
            for(char current = 'a'; current <= start; current++) {
                System.out.print(current);
            }
            System.out.println();
        }
        sc.close();
    }
}
