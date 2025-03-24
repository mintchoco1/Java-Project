package javacoding;

import java.util.Scanner;

public class Num3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input 3 integers >>");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        if(num1 > num2 && num1 > num3){
            if(num2 > num3){
                System.out.println("Middle number is " + num2);
            }
        }else if(num2 > num1 && num2 > num3){
            if(num1 > num3){
                System.out.println("Middle number is " + num1);
            }
        }else if(num3 > num1 && num3 > num2){
            if(num1 > num2){
                System.out.println("Middle number is " + num3);
            }
        }
        sc.close();
    }
}
