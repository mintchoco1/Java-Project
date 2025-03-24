package javacoding;

import java.util.Scanner;

public class Num18 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] subject = {"java", "c++", "html", "kotlin", "python"};
        int[] scores = {90, 80, 70, 60, 50};

        while(true) {
            System.out.print("Subject >>");
            String input = sc.nextLine();

            if(input.equalsIgnoreCase("quit")) {
                break;
            }

            boolean found = false;
            for(int i = 0; i < subject.length; i++) {
                if(subject[i].equalsIgnoreCase(input)) {
                    System.out.println("scores is " + scores[i]);
                    found = true;
                    break;
                }
            }
            if(!found) {
                System.out.println("Invalid input");
            }
        }
        sc.close();
    }
}
