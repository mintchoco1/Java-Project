package javacoding;

import java.util.Scanner;
import java.util.Random;

public class Num14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Random numbers : ");
        int[] nums = new int[10];//10칸 배열
        double sum = 0;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = 1 + (int) (Math.random() * 10);//2가지 방법 존재
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        double average = sum / nums.length;
        System.out.println("Average is " + average);

        sc.close();
    }
}
