package BJ.트리그래프;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_6593_상범빌딩 {

    static class Position{
        int l, r, c;

        public Position(int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.c = c;
        }

        public boolean equals(Position o) {
            if (l != o.l) return false;
            if (r != o.r) return false;
            return c == o.c;
        }
    }

    static int L, R, C;
    static char[][][] map;
    static Position start, end;

    static int[][] deltas = {{0,1,0},{0,-1,0},{0,0,1},{0,0,-1},{1,0,0},{-1,0,0}};

    public static boolean isIn(int l, int r, int c) {
        return 0 <= l && l < L && 0 <= r && r < R && 0 <= c && c < C;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            L = Integer.parseInt(token.nextToken());
            R = Integer.parseInt(token.nextToken());
            C = Integer.parseInt(token.nextToken());

            if(L == 0 && R == 0 && C == 0) break;

            map = new char[L][R][C];
            for(int l = 0; l < L; l++) {
                for(int r = 0; r < R; r++) {
                    String line = br.readLine();
                    for(int c = 0; c < C; c++){
                        map[l][r][c] = line.charAt(c);
                        if(map[l][r][c] == 'S') start = new Position(l, r, c);
                        else if(map[l][r][c] == 'E') end = new Position(l, r, c);
                    }
                }
                br.readLine();
            }

            int sec = bfs();
            bw.write(sec != -1 ? "Escaped in "+sec+" minute(s)." : "Trapped!");
            bw.newLine();

        }

        bw.flush();
        bw.close();
    }

    private static int bfs() {
        Queue<Position> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[L][R][C];

        queue.offer(start);
        visited[start.l][start.r][start.c] = true;

        int sec = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                Position p = queue.poll();
                if(p.equals(end)) return sec;

                for(int[] d : deltas) {
                    int nl = p.l + d[0];
                    int nr = p.r + d[1];
                    int nc = p.c + d[2];

                    if(isIn(nl, nr, nc) && !visited[nl][nr][nc] && (map[nl][nr][nc] == '.' || map[nl][nr][nc] == 'E')) {
                        visited[nl][nr][nc] = true;
                        queue.offer(new Position(nl, nr, nc));
                    }
                }
            }
            sec++;
        }
        return -1;
    }
}
