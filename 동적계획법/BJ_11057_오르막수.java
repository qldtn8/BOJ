package BJ.동적계획법;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_11057_오르막수 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] dp = new int[10];
        Arrays.fill(dp, 1);

        for(int n = 2; n <= N; n++) {
            for(int i = 1; i < 10; i++) {
                dp[i] = (dp[i] + dp[i-1]) % 10007;
            }
        }
        int sum = 0;
        for(int i = 0; i < 10; i++)
            sum = (sum + dp[i]) % 10007;

        System.out.println(sum);
    }
}
