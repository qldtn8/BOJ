package BJ.동적계획법;

import java.util.Scanner;

public class BJ_24416_알고리즘수업_피보나치수1 {

    static int count1;
    static int N;

    public static void fib1(int n) {
        if(n == 1 || n == 2) {
            count1++;
            return;
        }
        fib1(n-1);
        fib1(n-2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        count1 = 0;
        fib1(N);
        System.out.println(count1 + " " + (N-2));
    }
}
