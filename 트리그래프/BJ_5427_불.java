package BJ.트리그래프;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_5427_불 {

    static class Position {
        int r, c;
        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int R, C;
    static char[][] map;
    static Position sg;
    static Queue<Position> fire;

    static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            C = Integer.parseInt(token.nextToken());
            R = Integer.parseInt(token.nextToken());

            map = new char[R][C];
            fire = new LinkedList<>();
            for(int r = 0; r < R; r++) {
                String line = br.readLine();
                for(int c = 0; c < C; c++) {
                    map[r][c] = line.charAt(c);
                    if(map[r][c] == '@') {
                        sg = new Position(r, c);
                        map[r][c] = '.';
                    } else if(map[r][c] == '*') {
                        fire.offer(new Position(r, c));
                    }
                }
            }

            int sec = bfs();
            bw.write(sec != -1 ? sec+"" : "IMPOSSIBLE");
            bw.newLine();

        }

        bw.flush();
        bw.close();

    }

    private static int bfs() {
        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];

        queue.offer(sg);
        visited[sg.r][sg.c] = true;

        int sec = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            predictSpread();
            while(size-- > 0) {
                Position p = queue.poll();

                if(p.r == 0 || p.r == R-1 || p.c == 0 || p.c == C-1) {
                    if(map[p.r][p.c] != '*') {
                        return sec+1;
                    }
                }

                for(int[] d : deltas) {
                    int nr = p.r + d[0];
                    int nc = p.c + d[1];

                    if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == '.') {
                        visited[nr][nc] = true;
                        queue.offer(new Position(nr, nc));
                    }
                }
            }
            spread();
            sec++;
        }

        return -1;
    }
    private static void predictSpread() {
        int size = fire.size();
        while(size-- > 0) {
            Position p = fire.poll();

            for(int[] d : deltas) {
                int nr = p.r + d[0];
                int nc = p.c + d[1];
                if(isIn(nr, nc) && map[nr][nc] == '.') {
                    fire.offer(new Position(nr, nc));
                    map[nr][nc] = '!';
                }
            }
        }
    }

    private static void spread() {
        int size = fire.size();
        while(size-- > 0) {
            Position p = fire.poll();
            map[p.r][p.c] = '*';
            fire.offer(p);
        }
    }
}
