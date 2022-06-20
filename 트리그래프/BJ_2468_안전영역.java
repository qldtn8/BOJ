package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2468_안전영역 {

    static int N;
    static int[][] arr;

    static boolean[][] visited;
    static int[][] deltas = {{-1, 0},{1, 0},{0, -1},{0, 1}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        int max = 0;
        int min = 101;
        for(int r = 0; r < N; r++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(token.nextToken());
                if(max < arr[r][c]) max = arr[r][c];
                if(min > arr[r][c]) min = arr[r][c];
            }
        }

        int ans = 1;
        for(int h = min; h < max; h++) {
            int safeArea = findSafeArea(h);
            if(ans < safeArea) ans = safeArea;
        }
        System.out.println(ans);
    }

    // k이하인 모든 지점이 물에 잠겼을 때 안전한 영역
    public static int findSafeArea(int k) {
        int safeArea = 0;
        visited = new boolean[N][N];
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(!visited[r][c] && arr[r][c] > k) {
                    bfs(r, c, k);
                    safeArea++;
                }
            }
        }
        return safeArea;
    }

    public static void bfs(int r, int c, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;

        while(!queue.isEmpty()) {
            int[] pos = queue.poll();

            for(int[] d : deltas) {
                int nr = pos[0] + d[0];
                int nc = pos[1] + d[1];
                if(isIn(nr, nc) && !visited[nr][nc] && arr[nr][nc] > k) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
