import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int[][] deltas = {{1, -1}, {1, 0}, {1, 1}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        int[][] map = new int[N][M];
        for(int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        System.out.println(bfs(map));

    }

    public static int bfs(int[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        for(int c = 0; c < M; c++) {
            queue.add(new int[]{0, c, map[0][c], -1});
        }

        int min = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            int[] info = queue.poll();

            if(info[0] == N-1) {
                min = Math.min(min, info[2]);
                continue;
            }

            for(int d = 0; d < deltas.length; d++) {
                if(d != info[3]) {
                    int nr = info[0] + deltas[d][0];
                    int nc = info[1] + deltas[d][1];

                    if(isIn(nr, nc))
                        queue.add(new int[]{nr, nc, info[2] + map[nr][nc], d});
                }
            }
        }

        return min;
    }
}