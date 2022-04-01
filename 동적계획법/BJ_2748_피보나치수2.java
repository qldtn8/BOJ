package BJ.동적계획법;

import java.util.Scanner;

public class BJ_2748_피보나치수2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        long[] DP = new long[N+1];
        DP[0] = 0;
        DP[1] = 1;

        for(int i = 2; i < N+1; i++) {
            DP[i] = DP[i-1] + DP[i-2];
        }
        System.out.println(DP[N]);
    }
}
