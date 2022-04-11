package BJ.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10830_행렬제곱 {

    static int N;
    static long B;
    static int[][] A;

    public static int[][] multiple(int[][] x, int[][] y) {
        int[][] result = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    result[i][j] += (x[i][k]*y[k][j]) % 1000;
                }
            }
        }
        return result;
    }

    public static int[][] pow(int[][] a, long b) {
        if(b == 1L) {
            return a;
        } else if(b % 2 == 0) {
            int[][] aPowb = pow(a, b/2);
            return multiple(aPowb, aPowb);
        } else {
            int[][] aPowb = pow(a, (b-1)/2);
            aPowb = multiple(aPowb, aPowb);
            return multiple(a, aPowb);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        B = Long.parseLong(token.nextToken());

        A = new int[N][N];
        for(int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                A[r][c] = Integer.parseInt(token.nextToken()) % 1000;
            }
        }

        int[][] result = pow(A, B);
        for(int[] r : result) {
            for(int c : r) {
                System.out.print((c % 1000) + " ");
            }
            System.out.println();
        }

    }
}
