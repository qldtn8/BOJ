package BJ.트리그래프;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4963_섬의개수 {

    static int W, H;
    static boolean[][] map;

    static int[][] deltas = {{1, 0},{0, 1},{-1, 0},{0, -1},{1, 1},{1, -1},{-1, 1},{-1, -1}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < H && 0 <= c && c < W;
    }

    public static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        map[r][c] = false;

        while(!queue.isEmpty()) {
            int[] pos = queue.poll();

            for(int[] d : deltas) {
                int nr = pos[0] + d[0];
                int nc = pos[1] + d[1];
                if(isIn(nr, nc) && map[nr][nc]) {
                    map[nr][nc] = false;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while(!(line = br.readLine()).equals("0 0")) {
            StringTokenizer token = new StringTokenizer(line);
            W = Integer.parseInt(token.nextToken());
            H = Integer.parseInt(token.nextToken());

            map = new boolean[H][W];
            for(int r = 0; r < H; r++) {
                token = new StringTokenizer(br.readLine());
                for(int c = 0; c < W; c++) {
                    if(Integer.parseInt(token.nextToken()) == 1) map[r][c] = true;
                }
            }

            int total = 0;
            for(int r = 0; r < H; r++) {
                for(int c = 0; c < W; c++) {
                    if(map[r][c]) {
                        bfs(r, c);
                        total++;
                    }
                }
            }
            bw.write(total+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
