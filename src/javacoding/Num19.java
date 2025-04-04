package javacoding;

import java.util.Scanner;
class TV{
    String name;
    int year;
    int size;

    public TV(String name, int year, int size) {
        this.name = name;
        this.year = year;
        this.size = size;
    }
    public void show(){
        System.out.println("My TV is " + this.size + " inches manufactured by " + this.name + " in " + this.year);
    }
}
public class Num19 {
    public static void main(String[] args) {
        TV myTV = new TV("LG", 2021, 85);
        myTV.show();
    }
}
