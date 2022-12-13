import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Position {
        int r, c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M;
    static int[][] map;
    static int[][] deltas = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    static Position start;

    public static boolean isIn(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new int[N][M];
        for(int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(token.nextToken());
                if(map[n][m] == 2)
                    start = new Position(n, m);
            }
        }

        bfs();

        for (int[] row : map) {
            for(int col : row)
                bw.write(col + " ");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static void bfs() {
        boolean[][] visited = new boolean[N][M];
        visited[start.r][start.c] = true;
        Queue<Position> queue = new LinkedList<>();
        queue.add(start);

        int depth = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                Position pos = queue.poll();
                map[pos.r][pos.c] = depth;

                for(int[] d : deltas) {
                    int nr = pos.r + d[0];
                    int nc = pos.c + d[1];

                    if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
                        queue.add(new Position(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
            }
            depth++;
        }

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++)
                if(!visited[r][c] && map[r][c] != 0)
                    map[r][c] = -1;
        }
    }
}