package BJ.동적계획법;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_10942_펠린드롬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N+1];
        boolean[][] dp = new boolean[N+1][N+1];

        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            sequence[i] = Integer.parseInt(token.nextToken());
            dp[i][i] = true;
            if(i != 1 && sequence[i] == sequence[i-1]) dp[i-1][i] = true;
        }

        for(int d = 2; d <= N-2+1; d++) {
            for(int r = 1; r <= N-d; r++) {
                if(dp[r+1][(r+d-1)] && sequence[r] == sequence[r+d]) dp[r][r+d] = true;
            }
        }

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(token.nextToken());
            int E = Integer.parseInt(token.nextToken());

            bw.write(dp[S][E] ? "1\n" : "0\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
