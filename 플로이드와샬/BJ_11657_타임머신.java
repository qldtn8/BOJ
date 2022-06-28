package BJ.플로이드와샬;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11657_타임머신 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[][] dp = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], 5000001);
        }

        for(int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());

            dp[a][b] = c;
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                if(k == i) continue;;
                for(int j = 1; j <= N; j++) {
                    if(k != j && i != j) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    }
                }
            }
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                if(k == i) continue;;
                for(int j = 1; j <= N; j++) {
                    if(k != j && i != j) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    }
                }
            }
        }

        for(int[] a : dp) {
            for(int b : a) {
                System.out.print(b+"\t");
            }
            System.out.println();
        }

        StringBuilder sb = new StringBuilder();
        boolean timeMachine = false;
        for(int i = 2; i <= N; i++) {
            sb.append(dp[1][i]+"\n");
            if(dp[1][i] < 0) timeMachine = true;
        }

        if(timeMachine) System.out.println(-1);
        else System.out.println(sb.toString());
    }
}
