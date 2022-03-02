package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576_토마토 {

    static int N, M;
    static int[][] box;
    static int unripeTomatoes;
    static Queue<int[]> queue;

    static int[][] deltas = {{-1, 0},{1, 0},{0, -1},{0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());
        box = new int[N][M];
        unripeTomatoes = 0;
        queue = new LinkedList<>();

        for(int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                int temp = Integer.parseInt(token.nextToken());
                if(temp == 1) {
                    box[r][c] = temp;
                    queue.offer(new int[]{r, c});
                } else if(temp == -1){
                    box[r][c] = temp;
                } else {
                    unripeTomatoes++;
                }
            }
        }
        int day = bfs();
        System.out.println(unripeTomatoes == 0 ? day : -1);
    }

    public static int bfs() {
        int day = -1;   // 익은애들 queue에서 꺼낼 때 체크되는 day를 상쇄하기 위해 -1로 초기화
        while(!queue.isEmpty()) {
            day++;
            int size = queue.size();
            while(size-- > 0) {
                int[] temp = queue.poll();

                for(int d = 0; d < deltas.length; d++) {
                    int nr = temp[0] + deltas[d][0];
                    int nc = temp[1] + deltas[d][1];
                    if(0 <= nr && nr < N && 0 <= nc && nc < M && box[nr][nc] == 0) {
                        box[nr][nc] = 1;
                        unripeTomatoes--;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return day;
    }
}
