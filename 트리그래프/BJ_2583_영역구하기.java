package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2583_영역구하기 {

    static int N, M;
    static int K;
    static boolean[][] area;
    static LinkedList<Integer> remain;

    static int[][] deltas = {{-1, 0},{1, 0},{0, -1},{0, 1}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    public static void makeArr(int sr, int sc, int er, int ec) {
        for(int r = sr; r < er; r++) {
            for(int c = sc; c < ec; c++) {
                area[r][c] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        area = new boolean[N][M];
        for(int i = 0; i < K; i++) {
            token = new StringTokenizer(br.readLine());
            makeArr(Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken()));
        }

        remain = new LinkedList<>();
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(!area[r][c]) {
                    bfs(r, c);
                }
            }
        }

        StringBuilder output = new StringBuilder();
        Collections.sort(remain);
        output.append(remain.size()+"\n");
        for(int i = 0; i < remain.size(); i++) {
            output.append(remain.get(i)+" ");
        }
        System.out.println(output.toString());
    }

    public static void bfs(int row, int col) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        area[row][col] = true;

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            count++;

            for(int d = 0; d < deltas.length; d++) {
                int nr = temp[0] + deltas[d][0];
                int nc = temp[1] + deltas[d][1];
                if(isIn(nr, nc) && !area[nr][nc]) {
                    area[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        remain.add(count);
    }
}
