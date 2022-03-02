package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1051_숫자정사각형 {

    static int N, M;
    static char[][] arr;
    static int MAX;

    public static void maxRectangle(int r, int c, int d) {
        if(r+d <= N && c+d <= M) {
            if(arr[r][c] == arr[r+d-1][c] && arr[r][c] == arr[r][c+d-1] && arr[r][c] == arr[r+d-1][c+d-1]) {
                MAX = d;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new char[N][M];
        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        MAX = 1;
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                for(int d = MAX+1; d <= Math.min(N, M); d++) {
                    maxRectangle(r, c, d);
                }
            }
        }
        System.out.println(MAX*MAX);
    }
}
