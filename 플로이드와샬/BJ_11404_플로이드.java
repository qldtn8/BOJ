package BJ.플로이드와샬;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11404_플로이드 {

    static int N, M;
    static int[][] D;
    static final int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        D = new int[N+1][N+1];
        for(int r = 1; r <= N; r++) {
            for(int c = 1; c <= N; c++) {
                if(r != c) D[r][c] = INF;
            }
        }
        // D(0) 초기화
        for(int m = 0; m < M; m++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int v = Integer.parseInt(token.nextToken());
            D[a][b] = Math.min(D[a][b], v);
        }

        // Floyd-warshall
        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                if(k != i) {
                    for(int j = 1; j <= N; j++) {
                        if(k != j && i != j) {
                            D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
                        }
                    }
                }
            }
        }

        for(int r = 1; r <= N; r++) {
            for(int c = 1; c <= N; c++) {
                if(D[r][c] >= INF) System.out.print("0 ");
                else System.out.print(D[r][c]+" ");
            }
            System.out.println();
        }
    }
}
