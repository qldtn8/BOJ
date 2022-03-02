package BJ;

import java.util.Scanner;

/**
 * 별 찍기 - 8
 */
public class BJ_2445 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for(int i = 0; i < N-1; i++) {
            for(int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            for(int j = 0; j < 2*(N-1-i); j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N-i; j++) {
                System.out.print("*");
            }
            for(int j = 0; j < 2*i; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < N-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
