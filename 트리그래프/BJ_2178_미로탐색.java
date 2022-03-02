package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178_미로탐색 {

    static int N, M;
    static boolean[][] miro;
    static int min;

    static int[][] deltas = {{0, 1},{1, 0},{-1, 0},{0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        miro = new boolean[N+1][M+1];

        for(int r = 1; r < N+1; r++) {
            String line = br.readLine();
            for(int c = 1; c < M+1; c++) {
                miro[r][c] = (line.charAt(c-1) == '1') ? true : false;
            }
        }
//        min = Integer.MAX_VALUE;
//        dfs(1, 1, 1);
//        System.out.println(min);
        bfs();
    }

    public static boolean isIn(int r, int c) {
        return 1 <= r && r <= N && 1 <= c && c <= M;
    }

    public static void bfs() {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1});
        miro[1][1] = false;
        outer: while(!queue.isEmpty()) {
            int size = queue.size();
            count++;
            while(size-- > 0) {
                int[] temp = queue.poll();
                if(temp[0] == N && temp[1] == M) {
                    break outer;
                }
                for(int d = 0; d < deltas.length; d++) {
                    int nr = temp[0] + deltas[d][0];
                    int nc = temp[1] + deltas[d][1];
                    if(isIn(nr, nc) && miro[nr][nc]) {
                        miro[nr][nc] = false;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static void dfs(int r, int c, int count) {
        if(count > min) {
            return;
        }
        if(r == N && c == M) {
            if(count < min) {
                min = count;
            }
            return;
        }
        miro[r][c] = false;
        for(int d = 0; d < deltas.length; d++) {
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];
            if(isIn(nr, nc) && miro[nr][nc]) {
                dfs(nr, nc, count+1);
            }
        }
        miro[r][c] = true;
    }
}
