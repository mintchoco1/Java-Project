package javacoding;

import java.util.Scanner;

public class Num10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");

        double num1 = sc.nextDouble();
        String operator = sc.next();
        double num2 = sc.nextDouble();


        switch (operator) {
            case "+":
                System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                break;
            case "-":
                System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
                break;
            case "*":
                System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
                break;
            case "%":
                if(num2 == 0){
                    System.out.println("Divide by zero");
                }else{
                    System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
                }
                break;
            default:
                System.out.println("Invalid operator");
        }
        sc.close();
    }
}
