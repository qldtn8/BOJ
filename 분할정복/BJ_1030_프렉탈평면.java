package BJ.분할정복;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1030_프렉탈평면 {

    static int n;
    static int S, N, K;
    static int R1, R2, C1, C2;
    static boolean[][] arr;

    public static void fractal(int s, int row, int col) {
        if(s == 1) {
            int midR = (row+row+N)/2;
            int midC = (col+col+N)/2;
            System.out.println("midR : " + midR + " midC : " + midC);
            for(int r = midR-K/2; r < midR-K/2+K; r++) {
                for(int c = midC-K/2; c < midC-K/2+K; c++) {
                    arr[r][c] = true;
                }
            }
            return;
        }
        int temp = (int) Math.pow(N, s);
        int center = (temp/N) * (temp/N) / 2;
        // 중앙
        for(int r = row; r < row+temp; r += temp/N) {
            for(int c = col; c < col+temp; c += temp/N) {
                System.out.println((s-1) + " " + r + " " + c);
                fractal(s-1, r, c);
            }
        }
        // 주변
//        for(int r = row; r < row+temp/N; r++) {
//
//        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokens = new StringTokenizer(br.readLine());
        S = Integer.parseInt(tokens.nextToken());
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());

        R1 = Integer.parseInt(tokens.nextToken());
        R2 = Integer.parseInt(tokens.nextToken());
        C1 = Integer.parseInt(tokens.nextToken());
        C2 = Integer.parseInt(tokens.nextToken());

        n = (int)Math.pow(N, S);
        arr = new boolean[n][n];

        fractal(S, 0, 0);
        for(boolean[] a : arr) {
            for(boolean b : a) {
                System.out.print((b ? "1 " : "0 "));
            }
            System.out.println();
        }

    }
}
