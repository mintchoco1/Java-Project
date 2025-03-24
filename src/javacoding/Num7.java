package javacoding;

import java.util.Scanner;

public class Num7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //원의 중심과 반지름 입력
        System.out.println("Input center point & radius >> ");
        double radius = sc.nextDouble();
        double centerx = sc.nextDouble();
        double centery = sc.nextDouble();

        //점의 좌표 입력
        System.out.println("Input point >>");
        double x = sc.nextDouble();
        double y = sc.nextDouble();

        double distance = Math.sqrt(Math.pow(centerx - x, 2) + Math.pow(centery - y, 2));

        if(distance <= radius) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}
