package BJ.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2293_동전1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int[][] dp = new int[K+1][N];

        int[] coin = new int[N];
        for(int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
            if(coin[i] <= K)
                dp[coin[i]][i] = 1;
        }

        for(int k = 2; k <= K; k++) {
            for(int i = 0; i < N; i++) {
                if(k - coin[i] <= 0) continue;

                int sum = 0;
                for(int j = 0; j < N; j++)
                    if(coin[i] >= coin[j]) sum += dp[k-coin[i]][j];
                dp[k][i] = sum;
            }
        }

        int sum = 0;
        for(int i = 0; i < N; i++)
            sum += dp[K][i];
        System.out.println(sum);
    }
}
