package javacoding;

import java.util.Scanner;

class Day{
    private String todo;
    public void set(String todo){
        this.todo = todo;
    }
    public String get(){
        return todo;
    }
    public void show(){
        if(todo == null) {
            System.out.println("Nothing to do");
        }
        else{
            System.out.println("todo");
        }
    }
}

public class Num25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Day[] d = new Day[30];
        for (int i = 0; i < d.length; i++) {
            d[i] = new Day();
        }
        int choice;
        int date;

        while(true){
            System.out.println("Monthly schedule management system");
            System.out.println("Todo (Input: 1, Show: 2, Quit: 3");
            choice = sc.nextInt();

            if(choice == 1){
                System.out.println("Date (1~30)");
                System.out.println("Todo (Enter string without space)");

            }
            else if(choice == 2){
                System.out.println("Date (1~30)");
            }
            else if(choice == 3){
                System.out.println("Quit");
                break;
            }
        }
    }
}
