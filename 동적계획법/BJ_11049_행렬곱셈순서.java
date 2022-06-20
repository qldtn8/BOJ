package BJ.동적계획법;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11049_행렬곱셈순서 {

    static class Matrix {
        int r, c;
        public Matrix(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Matrix[] matrices = new Matrix[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            matrices[i] = new Matrix(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
        }

        int[][] dp = new int[N][N];
        for(int d = 1; d < N; d++) {
            for(int r = 0; r + d < N; r++) {
                int c = r + d;

                int min = Integer.MAX_VALUE;
                for(int l = r; l < c; l++) {
                    int cal = dp[r][l] + dp[l+1][c] + matrices[r].r * matrices[l].c * matrices[c].c;
                    min = Math.min(min, cal);
                }
                dp[r][r+d] = min;
            }
        }
        System.out.println(dp[0][N-1]);
    }
}
