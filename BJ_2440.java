package BJ;

import java.util.Scanner;

public class BJ_2440 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
