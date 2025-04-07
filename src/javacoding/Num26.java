package javacoding;

import java.util.Scanner;

class PhoneBook{
    private String number;
    private String name;
    public PhoneBook(String number, String name){
        this.number = number;
        this.name = name;
    }
    public String getNumber(){
        return number;
    }
    public String getName(){
        return name;
    }
}
public class Num26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of persons:");
        int persons = sc.nextInt();

        PhoneBook[] phoneBook = new PhoneBook[persons];

        for (int i = 0; i < persons; i++) {
            System.out.println("Input name & phone number:");
            String num = sc.next();
            String name = sc.next();
            phoneBook[i] = new PhoneBook(num, name);
        }
        while(true){
            System.out.println("Search >> ");
            String search = sc.next();
            if(search.equalsIgnoreCase("quit")){
                System.out.println("Quit program");
                break;
            }
        }
    }
}
