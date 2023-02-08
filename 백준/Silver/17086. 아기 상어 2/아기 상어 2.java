import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,-1},{-1,1}};

    static Queue<int[]> queue;

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <=c && c < M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new int[N][M];

        queue = new LinkedList<>();
        for(int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
                if(map[r][c] == 1)
                    queue.add(new int[]{r, c});
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        boolean[][] visited = new boolean[N][M];

        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while(size-- > 0) {
                int[] pos = queue.poll();

                for(int[] d : deltas) {
                    int nr = pos[0] + d[0];
                    int nc = pos[1] + d[1];

                    if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 0) {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return depth-1;
    }
}