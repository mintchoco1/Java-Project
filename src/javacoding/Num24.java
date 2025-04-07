package javacoding;

import java.util.Scanner;

class Circle2{
    private double x, y;
    private int radius;
    public Circle2(double x, double y, int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    @Override
    public String toString(){
        return "(" + x + ", " + y + ") r = " + radius;
    }
}

public class Num24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle2 c2[] = new Circle2[3];
        int big_radius = 0;
        Circle2 big_circle = null;

        for (int i = 0; i < 3; i++) {
            System.out.println("x, y, radius >>");
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            int radius = sc.nextInt();
            c2[i] = new Circle2(x, y, radius);

            if (radius > big_radius) {
                big_radius = radius;
                big_circle = c2[i];
            }
        }

        //자바에서 객체를 직접 호출하려고 하면 toString() 메서드가 자동으로 호출
        //객체가 초기화되지 않은 상태(null)에서 메서드를 호출하려고 하면 NullPointerException 발생
        //
        if (big_circle != null) {
            System.out.println("Biggest circle is " + big_circle.toString());
        }
    }
}
