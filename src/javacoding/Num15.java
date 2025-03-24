package javacoding;

import java.util.Scanner;
import java.util.Random;

public class Num15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 + (int) (Math.random() * 100);
            System.out.print(arr[i] + " ");
            //i + 1 은 요소의 인덱스를 1 부터 시작하는 것처럼 만들수 있음
            if((i + 1) % 10 == 0){
                System.out.println();
            }
        }

        sc.close();
    }
}