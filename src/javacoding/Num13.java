package javacoding;

import java.util.Scanner;

public class Num13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input 10 positive integers: ");
        int[] num = new int[10];//정수 10개 담을 수 있는 배열

        for(int i = 0; i < num.length; i++){
            num[i] = sc.nextInt();
        }
        //그 중에서 3의 배수만 출력
        for(int i = 0; i < num.length; i++){
            if(num[i] % 3 == 0){
                System.out.println(num[i]);
            }else {
                System.out.println();
            }
        }
    sc.close();
    }
}
