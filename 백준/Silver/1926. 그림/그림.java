import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int[][] map;
    public static boolean[][] visited;

    public static int maxArea;
    public static int total;

    public static int[][] deltas = {{1, 0},{-1, 0},{0, 1},{0, -1}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++)
                map[r][c] = Integer.parseInt(token.nextToken());
        }

        maxArea = Integer.MIN_VALUE;
        total = 0;
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(!visited[r][c] && map[r][c] == 1) {
                    bfs(r, c);
                }
            }
        }
        System.out.println(total);
        System.out.println(maxArea == Integer.MIN_VALUE ? 0 : maxArea);
    }

    public static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});

        visited[r][c] = true;

        int count = 0;
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            count++;

            for(int[] d : deltas) {
                int nr = point[0] + d[0];
                int nc = point[1] + d[1];

                if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        total++;
        if(maxArea < count)
            maxArea = count;
    }
}