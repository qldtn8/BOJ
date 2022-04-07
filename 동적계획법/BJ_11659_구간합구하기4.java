package BJ.동적계획법;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11659_구간합구하기4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[] arr = new int[N];
        int[] dp = new int[N+1];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
            dp[i+1] = dp[i] + arr[i];
        }

        while(M-- > 0) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int sum = dp[b] - dp[a-1];

            bw.write(sum+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

