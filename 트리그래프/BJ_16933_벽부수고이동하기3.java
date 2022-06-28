package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16933_벽부수고이동하기3 {

    static class Position {
        int r, c, k;
        boolean isNight;
        public Position(int r, int c, int k, boolean isNight) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.isNight = isNight;
        }
    }

    static int R, C, K;
    static boolean[][] map;

    static int[][] deltas = {{1, 0},{-1, 0},{0, 1},{0, -1}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        map = new boolean[R][C];
        for(int r = 0; r < R; r++) {
            String line = br.readLine();
            for(int c = 0; c < C; c++) {
                map[r][c] = line.charAt(c) == '0' ? true : false;
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Position> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[R][C][K+1];

        queue.offer(new Position(0, 0, 0, false));
        visited[0][0][0] = true;

        int distance = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            while(size-- > 0) {
                Position p = queue.poll();

                if(p.r == R-1 && p.c == C-1) {
                    return distance;
                }

                for(int[] d : deltas) {
                    int nr = p.r + d[0];
                    int nc = p.c + d[1];

                    if(isIn(nr, nc)) {
                        if(map[nr][nc] && !visited[nr][nc][p.k]) {
                            visited[nr][nc][p.k] = true;
                            queue.offer(new Position(nr, nc, p.k, !p.isNight));
                        } else if(!map[nr][nc] && p.k < K && !visited[nr][nc][p.k+1]) {
                            if(!p.isNight) {
                                visited[nr][nc][p.k + 1] = true;
                                queue.offer(new Position(nr, nc, p.k + 1, !p.isNight));
                            } else {
                                queue.offer(new Position(p.r, p.c, p.k, !p.isNight));
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
