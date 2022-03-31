package BJ.트리그래프;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1261_알고스팟 {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(br.readLine());

        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                if(line.charAt(j) == '1')
                    map[i][j] = 1;
            }
        }

        // -----입력 끝-------

        boolean[][][] visited = new boolean[N][M][N+M-1];
        Queue<Position> queue = new LinkedList<>();


    }

    static class Position {
        int r, c, k;
        public Position(int r, int c, int k) {
            this.r = r;
            this.c = c;
            this.k = k;
        }
    }
}
