package BJ.비트마스킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14391_종이조각 {

    static int N, M;
    static int[][] matrix;
    static boolean[][] bitmask;
    static int max;

    public static int calculate() {
        int sum = 0;
        for(int r = 0; r < N; r++) {
            int temp = 0;
            for(int c = 0; c < M; c++) {
                if(bitmask[r][c]) {
                    temp = temp * 10 + matrix[r][c];
                } else {
                    sum += temp;
                    temp = 0;
                }
            }
            sum += temp;
        }
        for(int c = 0; c < M; c++) {
            int temp = 0;
            for(int r = 0; r < N; r++) {
                if(!bitmask[r][c]) {
                    temp = temp * 10 + matrix[r][c];
                } else {
                    sum += temp;
                    temp = 0;
                }
            }
            sum += temp;
        }

        return sum;
    }

    public static void subset(int nth) {
        if(nth == N*M) {
            int sum = calculate();
            if(sum > max) max = sum;
            return;
        }

        int r = nth / M;
        int c = nth % M;

        bitmask[r][c] = true;
        subset(nth+1);

        bitmask[r][c] = false;
        subset(nth+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        matrix = new int[N][M];
        for(int r = 0; r < N; r++) {
            String line = br.readLine();
            for(int c = 0; c < M; c++) {
                matrix[r][c] = line.charAt(c) - '0';
            }
        }

        max = Integer.MIN_VALUE;
        bitmask = new boolean[N][M];
        subset(0);
        System.out.println(max);

    }
}
