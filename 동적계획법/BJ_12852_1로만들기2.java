package BJ.동적계획법;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BJ_12852_1로만들기2 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = scanner.nextInt();

        int[] dp = new int[N+1];
        int[] idx = new int[N+1];
        dp[0] = Integer.MAX_VALUE;
        for(int i = 2; i <= N; i++) {
            idx[i] = i-1;
            dp[i] = dp[i-1] + 1;
            if(i % 2 == 0 && dp[i] > dp[i/2] + 1) {
                dp[i] = dp[i/2] + 1;
                idx[i] = i / 2;
            }
            if(i % 3 == 0 && dp[i] > dp[i/3] + 1) {
                dp[i] = dp[i/3] + 1;
                idx[i] = i / 3;
            }
        }
        bw.write(dp[N]+"\n"+N+" ");
        int count = N;
        while(count > 1) {
            bw.write(idx[count] + " ");
            count = idx[count];
        }
        bw.flush();
        bw.close();
        scanner.close();
    }
}
