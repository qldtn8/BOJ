package BJ.동적계획법;

import java.util.Scanner;

public class BJ_2193_이친수 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        long[][] dp = new long[N+1][2];
        dp[1][0] = 1;   // 마지막 자리의 1의 개수
        dp[1][1] = 1;   // 총 이친수 개수
        for(int i = 2; i <= N; i++) {
            dp[i][1] = dp[i-1][1]*2 - dp[i-1][0];
            dp[i][0] = dp[i-1][1] - dp[i-1][0];
        }
        System.out.println(dp[N][1]);
    }
}
