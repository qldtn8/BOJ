package BJ.동적계획법;

import java.util.Scanner;

public class BJ_9655_돌게임 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] DP = new int[N+1];
        DP[1] = 1;
        for(int i = 2; i < N+1; i++) {
            int a = DP[i-1] + 1;
            int b = Integer.MAX_VALUE;
            if(i-3 > 0) b = DP[i-3] + 1;

            DP[i] = Math.min(a, b);
        }
        System.out.println(DP[N] % 2 == 0 ? "CY" : "SK");
    }
}
