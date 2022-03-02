package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7569_토마토 {

    static int[][][] arr =  { {{1, 2},{3, 4}},{{5, 6},{7, 8}}  };

    static int M, N, H;
    static int[][][] box;
    static int unripeTomato;
    static Queue<int[]> queue;

    static int[][] deltas = {{0, 1, 0}, {0, -1, 0}, {0, 0, -1}, {0, 0, 1}, {1, 0, 0}, {-1, 0, 0}};

    public static boolean isIn(int h, int n, int m) {
        return 0<= h && h < H && 0 <= n && n < N && 0 <= m && m < M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());
        H = Integer.parseInt(token.nextToken());

        box = new int[H][N][M];
        queue = new LinkedList<>();
        for(int h = 0; h < H; h++) {
            for(int n = 0; n < N; n++) {
                token = new StringTokenizer(br.readLine());
                for(int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(token.nextToken());
                    if(box[h][n][m] == 0) {
                        unripeTomato++;
                    }
                    if(box[h][n][m] == 1) {
                        queue.offer(new int[]{h, n, m});
                    }
                }
            }
        }

        int day = -1;   // 익은 토마토부터 시작하므로 -1
        while(!queue.isEmpty()) {
            int size = queue.size();
            day++;
            while(size-- > 0) {
                int[] location = queue.poll();

                for(int d = 0; d < deltas.length; d++) {
                    int nh = location[0] + deltas[d][0];
                    int nr = location[1] + deltas[d][1];
                    int nc = location[2] + deltas[d][2];
                    if(isIn(nh, nr, nc) && box[nh][nr][nc] == 0) {
                        box[nh][nr][nc] = 1;
                        unripeTomato--;
                        queue.offer(new int[]{nh, nr, nc});
                    }
                }
            }
        }
        System.out.println(unripeTomato == 0 ? day : -1);
    }
}
