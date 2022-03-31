package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2206_벽부수고이동하기 {

    static int N, M;

    static int[][] deltas = {{1, 0},{-1, 0},{0, 1},{0, -1}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        boolean[][][] visited = new boolean[N][M][2];
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0, 0));
        visited[0][0][0] = true;

        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while(size-- > 0) {
                Position p = queue.poll();

                if(p.r == N-1 && p.c == M-1) {
                    System.out.println(depth);
                    return;
                }

                for(int d = 0; d < deltas.length; d++) {
                    int nr = p.r + deltas[d][0];
                    int nc = p.c + deltas[d][1];
                    if(isIn(nr, nc)) {
                        if(map[nr][nc] == 0 && !visited[nr][nc][p.k]) {
                            visited[nr][nc][p.k] = true;
                            queue.offer(new Position(nr, nc, p.k));
                        }
                        if(p.k < 1 && map[nr][nc] == 1 && !visited[nr][nc][p.k+1]) {
                            visited[nr][nc][p.k+1] = true;
                            queue.offer(new Position(nr, nc, p.k+1));
                        }
                    }
                }
            }
        }
        System.out.println(-1);

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
