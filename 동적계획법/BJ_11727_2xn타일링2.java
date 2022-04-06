package BJ.동적계획법;

import java.util.Scanner;

public class BJ_11727_2xn타일링2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        if(N == 1) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 3;
        for(int i = 3; i <= N; i++) {
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
        }
        System.out.println(dp[N]);
    }
}
