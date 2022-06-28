package BJ.순열조합부분집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_18290_NM과K_1 {

    static int N, M, K;
    static int[][] matrix;
    static int max;

    static boolean[][] visited;

    static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    public static boolean canUse(int r, int c) {
        for(int[] d : deltas) {
            int nr = r + d[0];
            int nc = c + d[1];
            if(isIn(nr, nc) && visited[nr][nc]) return false;
        }
        return true;
    }

    public static void combination(int nth, int start, int sum) {
        if(nth == K) {
            if(max < sum) max = sum;
            return;
        }

        for(int i = start; i < N*M; i++) {
            int r = i / M;
            int c = i % M;
            if(!visited[r][c] && canUse(r, c)) {
                visited[r][c] = true;
                combination(nth+1, i+1, sum+matrix[r][c]);
                visited[r][c] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        matrix = new int[N][M];
        for(int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                matrix[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        max = Integer.MIN_VALUE;
        visited = new boolean[N][M];
        combination(0, 0, 0);
        System.out.println(max);

    }
}
