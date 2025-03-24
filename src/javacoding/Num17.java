package javacoding;

import java.util.Scanner;

public class Num17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] index = new int[4][4];//4 x 4 행렬 생성

        int count = 0;

        //랜덤한 숫자 10개만 골라서 집어넣기
        while(count < 10){
            int row = sc.nextInt(4);
            int col = sc.nextInt(4);

            if(index[row][col] == 0){
                index[row][col] = 1 + (int)(Math.random()*10);
                count++;
            }
        }
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(index[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
