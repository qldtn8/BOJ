package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1194_달이차오른다가자 {

    static int N, M;
    static char[][] map;
    static int x, y;

    static int[][] deltas = {{-1, 0},{1, 0},{0, 1},{0, -1}};
    public static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        //keys = new boolean[6];
        map = new char[N][M];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == '0') {
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        boolean[][][] visited = new boolean[N][M][64];
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(x, y, 0, 0));
        visited[x][y][0] = true;

        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                Position p = queue.poll();
                if(map[p.r][p.c] == '1') {
                    return p.depth;
                }

                // 현재가 키일 경우
                if("abcdef".indexOf(String.valueOf(map[p.r][p.c])) != -1 ) {
                    p.key = p.key | 1 << (int)(map[p.r][p.c] - 'a');
                } else if("ABCDEF".indexOf(String.valueOf(map[p.r][p.c])) != -1) {
                    if((p.key & 1 << (int)(map[p.r][p.c]-'A')) == 0) {
                        continue;
                    }
                }

                for(int d = 0; d < deltas.length; d++) {
                    int nr = p.r + deltas[d][0];
                    int nc = p.c + deltas[d][1];

                    if(isIn(nr, nc) && !visited[nr][nc][p.key] && map[nr][nc] != '#') {
                        visited[nr][nc][p.key] = true;
                        queue.offer(new Position(nr, nc, depth+1, p.key));
                    }
                }
            }
            depth++;
        }
        return -1;
    }

    static class Position {
        int r, c, depth, key;
        public Position(int r, int c, int depth, int key) {
            this.r = r;
            this.c = c;
            this.depth = depth;
            this.key = key;
        }
    }
}
