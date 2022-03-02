package BJ;

import java.util.Scanner;

public class BJ_2439 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N-1-i; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
