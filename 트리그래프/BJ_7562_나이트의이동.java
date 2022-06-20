package BJ.트리그래프;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7562_나이트의이동 {

    static int L;
    static int knightR, knightC;
    static int desR, desC;

    static int[][] deltas = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < L && 0 <= c && c < L;
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[L][L];

        queue.offer(new int[]{knightR, knightC});
        visited[knightR][knightC] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] pos = queue.poll();
                if (pos[0] == desR && pos[1] == desC) {
                    return count;
                }

                for (int[] delta : deltas) {
                    int nr = pos[0] + delta[0];
                    int nc = pos[1] + delta[1];
                    if (isIn(nr, nc) && !visited[nr][nc]) {
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            L = Integer.parseInt(br.readLine());

            StringTokenizer token = new StringTokenizer(br.readLine());
            knightR = Integer.parseInt(token.nextToken());
            knightC = Integer.parseInt(token.nextToken());

            token = new StringTokenizer(br.readLine());
            desR = Integer.parseInt(token.nextToken());
            desC = Integer.parseInt(token.nextToken());

            bw.write(bfs() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
