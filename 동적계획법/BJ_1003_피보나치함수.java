package BJ.동적계획법;

import java.io.*;

public class BJ_1003_피보나치함수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] dp = new int[41][2];
        dp[0][0] = 1; dp[0][1] = 0;
        dp[1][0] = 0; dp[1][1] = 1;
        for(int i = 2; i < 41; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            bw.write(dp[N][0] +" " + dp[N][1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
