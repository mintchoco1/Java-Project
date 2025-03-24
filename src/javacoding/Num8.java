package javacoding;

import java.util.Scanner;

public class Num8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //first circle
        System.out.println("Input center and radius of 1st circle >> ");
        double radius1 = sc.nextDouble();
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        //second circle
        System.out.println("Input center and radius of 2nd circle >> ");
        double radius2 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        //두 원의 중심의 거리를 구하기
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        if(distance < radius1 + radius2 || distance == radius1 + radius2) {
            System.out.println("Two circles are overlapped");
        }else{
            System.out.println("Two circles are not overlapped");
        }
        sc.close();
    }
}
