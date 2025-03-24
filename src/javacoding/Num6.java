package javacoding;

import java.util.Scanner;

public class Num6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //사각형
        int x1 = 100;
        int y1 = 100;
        int x2 = 200;
        int y2 = 200;

        System.out.println("Input (x, y) >> ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        if(x > x1 && y > y1 && x < x2 && y < y2){
            System.out.println("point (" + x + "," + y + ") is in the rectangle.");
        }else{
            System.out.println("point (" + x + "," + y + ") is not in the rectangle.");
        }
        sc.close();
    }
}
