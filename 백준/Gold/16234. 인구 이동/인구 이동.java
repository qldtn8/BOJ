import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int N, L, R;
    public static int[][] A;
    public static int[][] deltas = {{-1, 0},{1, 0},{0, -1},{0, 1}};

    public static boolean[][] visited;

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        L = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());

        A = new int[N][N];
        for(int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                A[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        int day = 0;
        while(true) {
            boolean possible = false;
            visited = new boolean[N][N];

            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    if(visited[r][c]) continue;

                    if(bfs(r, c))
                        possible = true;
                }
            }
            if(!possible) break;
            day++;
        }
        System.out.println(day);
    }

    public static boolean bfs(int r, int c) {
        visited[r][c] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});

        List<int[]> union = new LinkedList<>();
        union.add(new int[]{r, c});

        int sum = 0;
        int count = 0;
        while(!queue.isEmpty()) {
            int[] p = queue.poll();

            sum += A[p[0]][p[1]];
            count++;

            for(int[] d : deltas) {
                int nr = p[0] + d[0];
                int nc = p[1] + d[1];

                if(isIn(nr, nc) && !visited[nr][nc]) {
                    int diff = Math.abs(A[p[0]][p[1]] - A[nr][nc]);
                    if(L <= diff && diff <= R) {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                        union.add(new int[]{nr, nc});
                    }
                }
            }
        }

        if(count == 1) {
            visited[r][c] = false;
            return false;
        }

        for (int[] point : union) {
            A[point[0]][point[1]] = sum / count;
        }
        return true;
    }
}