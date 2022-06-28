package BJ.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17404_RGB거리2 {

    static int N;
    static int[][] cost;

    public static int minCost(int[][] dp, int color) {
        for(int i = 2; i <= N; i++) {
            for(int k = 0; k < 3; k++) {
                dp[i][k] = cost[i][k] + Math.min(dp[i-1][(k+1) % 3], dp[i-1][(k+2) % 3]);
            }
        }
        return Math.min(dp[N][(color+1) % 3], dp[N][(color+2) % 3]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cost = new int[N+1][3];
        for(int i = 1; i <= N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(token.nextToken());
            int G = Integer.parseInt(token.nextToken());
            int B = Integer.parseInt(token.nextToken());
            cost[i] = new int[]{R, G, B};
        }

        int[][] dp = new int[N+1][3];
        dp[1] = new int[]{cost[1][0], 1000000, 1000000};
        int R = minCost(dp, 0);

        dp[1] = new int[]{1000000, cost[1][1], 1000000};
        int G = minCost(dp, 1);

        dp[1] = new int[]{1000000, 1000000, cost[1][2]};
        int B = minCost(dp, 2);

        System.out.println(Math.min(R, Math.min(G, B)));
    }
}
