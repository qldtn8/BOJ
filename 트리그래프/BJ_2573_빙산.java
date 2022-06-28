package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2573_빙산 {

    static class Position {
        int r, c;
        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int R, C;
    static int[][] map;
    static Queue<Position> water;
    static int ice;

    static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        map = new int[R][C];
        water = new LinkedList<>();
        for(int r = 0; r < R; r++) {
            token = new StringTokenizer(br.readLine());
            for(int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
                if(map[r][c] == 0) water.offer(new Position(r, c));
                else ice++;
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {

        int year = 0;
        while(!water.isEmpty()) {
            int size = water.size();
            year++;

            while(size-- > 0) {
                Position p = water.poll();

                boolean remove = true;
                for(int[] d : deltas) {
                    int nr = p.r + d[0];
                    int nc = p.c + d[1];
                    if(isIn(nr, nc) && map[nr][nc] != 0) {
                        remove = false;
                        if(--map[nr][nc] == 0) {
                            ice--;
                            water.offer(new Position(nr, nc));
                        }
                    }
                }
                if(!remove) water.offer(p);
            }
            if(ice == 0) return 0;
            if(icebergBFS()) break;
        }
        return year;
    }

    public static boolean icebergBFS() {
        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];

        for(int r = 1; r < R-1; r++) {
            boolean find = false;
            for(int c = 1; c < C-1; c++) {
                if(map[r][c] != 0) {
                    find = true;
                    queue.offer(new Position(r, c));
                    visited[r][c] = true;
                    break;
                }
            }
            if(find) break;
        }

        int count = 0;
        while(!queue.isEmpty()) {
            Position p = queue.poll();
            count++;

            for(int[] d : deltas) {
                int nr = p.r + d[0];
                int nc = p.c + d[1];
                if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] != 0) {
                    visited[nr][nc] = true;
                    queue.offer(new Position(nr, nc));
                }
            }
        }

        if(count == ice) return false;
        else return true;
    }
}
