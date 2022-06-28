package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_6087_레이저통신 {

    static class Position {
        int r, c;
        int dir, mirror;
        public Position(int r, int c, int dir, int mirror) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.mirror = mirror;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "r=" + r +
                    ", c=" + c +
                    ", dir=" + dir +
                    ", mirror=" + mirror +
                    '}';
        }
    }

    static int R, C;
    static char[][] map;
    static Position laser, target;

    static int[][] deltas = {{1, 0},{0, 1},{-1, 0},{0, -1}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        C = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());

        map = new char[R][C];
        for(int r = 0; r < R; r++) {
            String line = br.readLine();
            for(int c = 0; c < C; c++) {
                map[r][c] = line.charAt(c);
                if(map[r][c] == 'C') {
                    if(laser == null) laser = new Position(r, c, -1, 0);
                    else target = new Position(r, c, 0, 0);
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Position> queue = new LinkedList<>();
        boolean[][][] visited= new boolean[R][C][R*C];

        queue.offer(laser);
        visited[laser.r][laser.c][0] = true;

        int minMirror = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            Position p = queue.poll();

            if(p.r == target.r && p.c == target.c) {
                if(minMirror > p.mirror) minMirror = p.mirror;
                continue;
            }

            for(int d = 0; d < deltas.length; d++) {
                if((p.dir + 2) % 4 == d) continue;

                int nr = p.r + deltas[d][0];
                int nc = p.c + deltas[d][1];

                if(isIn(nr, nc) && map[nr][nc] != '*') {
                    int k = (p.dir == -1 || p.dir == d) ? p.mirror : p.mirror+1;
                    if(!visited[nr][nc][k] && minMirror >= k) {
                        visited[nr][nc][k] = true;
                        queue.offer(new Position(nr, nc, d, k));
                    }
                }
            }
        }
        return minMirror;
    }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_6087_레이저통신 {

    static class Position {
        int r, c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int R, C;
    static char[][] map;
    static Position laser, target;
    static int minMirror;
    static boolean[][] visited;

    static int[][] deltas = {{1, 0},{0, 1},{-1, 0},{0, -1}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    public static void dfs(Position p, int numOfMirror, int prevDir) {
        if(minMirror < numOfMirror) return;

        if(p.r == target.r && p.c == target.c) {
            if(numOfMirror < minMirror) minMirror = numOfMirror;
            return;
        }

        for(int d = 0; d < deltas.length; d++) {
            int nr = p.r + deltas[d][0];
            int nc = p.c + deltas[d][1];

            if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] != '*') {
                visited[nr][nc] = true;
                if(prevDir == -1 || prevDir == d || (prevDir + 2) % 4 == d)
                    dfs(new Position(nr ,nc), numOfMirror, d);
                else
                    dfs(new Position(nr, nc), numOfMirror+1, d);
                visited[nr][nc] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        C = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());

        map = new char[R][C];
        for(int r = 0; r < R; r++) {
            String line = br.readLine();
            for(int c = 0; c < C; c++) {
                map[r][c] = line.charAt(c);
                if(map[r][c] == 'C') {
                    if(laser == null) laser = new Position(r, c);
                    else target = new Position(r, c);
                }
            }
        }

        minMirror = Integer.MAX_VALUE;
        visited = new boolean[R][C];
        visited[laser.r][laser.c] = true;
        dfs(laser, 0, -1);

        System.out.println(minMirror);
    }
}
 */
