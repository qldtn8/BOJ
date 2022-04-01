package BJ.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149_RGB거리 {

    static int N;
    static int[][] rgb;

    public static void findMinCost() {
        int[][] DP = new int[N][3];
        DP[0] = rgb[0];
        for(int i = 1; i < N; i++) {
            DP[i][0] = Math.min(DP[i-1][1], DP[i-1][2]) + rgb[i][0];
            DP[i][1] = Math.min(DP[i-1][0], DP[i-1][2]) + rgb[i][1];
            DP[i][2] = Math.min(DP[i-1][0], DP[i-1][1]) + rgb[i][2];
        }
        System.out.println(Math.min(DP[N-1][0], Math.min(DP[N-1][1], DP[N-1][2])));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        rgb = new int[N][3];
        for(int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        findMinCost();
    }
}
