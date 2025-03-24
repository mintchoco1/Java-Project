package javacoding;

import java.util.Scanner;

public class Num16 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] index = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                index[i][j] = 1 + (int)(Math.random() * 10);
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(index[i][j] + " ");
            }
        }
        sc.close();
    }
}
