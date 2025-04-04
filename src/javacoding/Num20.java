package javacoding;

import java.util.Scanner;

public class Num20 {
    //static 사용하면 값을 공유할 수 있음. 같은 메모리 주소만 바라보기 때문
    //
    static int average;

    public static class Grade{

        public Grade(int math, int science, int english) {
            int total = math + science + english;
            average = total / 3;
        }
        public int average(){
            return average;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input Scores in order of Math, Science and English >>");
        int math = sc.nextInt();
        int science = sc.nextInt();
        int english = sc.nextInt();

        Grade me = new Grade(math, science, english);
        System.out.println("Average : " + me.average());
        sc.close();
    }
}

