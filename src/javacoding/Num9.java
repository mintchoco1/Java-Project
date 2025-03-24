package javacoding;

import java.util.Scanner;

public class Num9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input month (1 ~ 12)");
        int month = sc.nextInt();

        if(month < 2 || month >= 12){
            System.out.println("Winter");
        } else if (month <=8 || month >=6) {
            System.out.println("Summer");
        }else if(month <=3 || month >=5){
            System.out.println("Spring");
        }else if(month >=9 || month <=11){
            System.out.println("Autumn");
        }else{
            System.out.println("Invlid");
        }
        sc.close();
    }
}
