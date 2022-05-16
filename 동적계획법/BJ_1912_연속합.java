package BJ.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1912_연속합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];  // i번째 값까지 연속해서 더한 수와 i번째 값 중 최대값을 저장.
        StringTokenizer token = new StringTokenizer(br.readLine());
        dp[0] = Integer.parseInt(token.nextToken());
        int max = dp[0];    // 모든 자리의 수를 고려했을 때 연속된 값의 최대 값 저장.
        for(int i = 1; i < N; i++) {
            int num = Integer.parseInt(token.nextToken());
            dp[i] = Math.max(dp[i-1]+num, num);
            if(max < dp[i]) max = dp[i];
        }
        System.out.println(max);
    }
}
