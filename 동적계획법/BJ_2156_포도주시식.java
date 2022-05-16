package BJ.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2156_포도주시식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][3];
        dp[1][1] = dp[1][2] = Integer.parseInt(br.readLine());
        for(int i = 2; i < N+1; i++) {
            int k = Integer.parseInt(br.readLine());

            dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);    // 현재의 포도주를 마시지 않을 때
            dp[i][1] = dp[i-1][0] + k;    // 현재의 포도주가 첫번째 잔일 때
            dp[i][2] = dp[i-1][1] + k;  // 현재의 포도주가 두번째 잔일 때
        }
        System.out.println(Math.max(Math.max(dp[N][0], dp[N][1]), dp[N][2]));
    }
}
