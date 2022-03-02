package BJ.그리디알고리즘;

import java.util.Scanner;

public class BJ_2839_설탕배달 {

    static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        int total5 = 0;
        int total3 = 0;
        if(N / 5 != 0) {
            total5 += N / 5;
            N %= 5;
        }
        if(N / 3 != 0) {
            total3 += N / 3;
            N %= 3;
        }

        if(N != 0) {
            while(total5 > 0) {
                total5--;
                N += 5;

                if(N % 3 == 0) {
                    total3 += N / 3;
                    N = 0;
                    break;
                }
            }
            if(N != 0) {
                System.out.println(-1);
            } else {
                System.out.println(total5 + total3);
            }
        } else {
            System.out.println(total5 + total3);
        }
    }
}
