package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1600_말이되고픈원숭이 {

    static int K;
    static int N, M;
    static int[][] arr;
    static boolean[][][] visit;

    static int min;

    static int[][] deltas = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    static int[][] horses = {{-1, -2},{-2, -1},{-1, 2},{-2, 1},{1, -2},{2, -1},{1, 2},{2, 1}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer token = new StringTokenizer(br.readLine());
        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());

        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        //----------------입력 끝----------------------

        visit = new boolean[N][M][K];
        visit[0][0][0] = true;
        min = Integer.MAX_VALUE;
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0, 0));
        int depth = -1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while(size-- > 0) {
                Position p = queue.poll();

                if(p.r == N-1 && p.c == M-1) {
                    System.out.println(depth);
                    return;
                }

                if(p.k < K) {
                    for (int h = 0; h < horses.length; h++) {
                        int nr = p.r + horses[h][0];
                        int nc = p.c + horses[h][1];
                        if (isIn(nr, nc) && !visit[nr][nc][p.k+1] && arr[nr][nc] == 0) {
                            visit[nr][nc][p.k+1] = true;
                            queue.offer(new Position(p.k + 1, nr, nc));
                        }
                    }
                }
                for (int d = 0; d < deltas.length; d++) {
                    int nr = p.r + deltas[d][0];
                    int nc = p.c + deltas[d][1];
                    if (isIn(nr, nc) && !visit[nr][nc][p.k] && arr[nr][nc] == 0) {
                        visit[nr][nc][p.k] = true;
                        queue.offer(new Position(p.k, nr, nc));
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static class Position {
        int k, r, c;
        public Position(int k, int r, int c) {
            this.k = k;
            this.r = r;
            this.c = c;
        }
    }
}
