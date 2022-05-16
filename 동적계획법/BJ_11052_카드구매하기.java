package BJ.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11052_카드구매하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++)
            dp[i] = Integer.parseInt(token.nextToken());

        for(int i = 2; i <= N; i++) {
            for(int j = 1; j <= i/2; j++) {
                if(dp[i] < dp[j] + dp[i-j]) dp[i] = dp[j] + dp[i-j];
            }
        }
        System.out.println(dp[N]);
    }
}
