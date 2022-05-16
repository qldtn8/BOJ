package BJ.트리그래프;

import java.io.*;
import java.util.*;

public class BJ_1012_유기농배추 {

    static class Position {
        int r, c;
        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int M, N;
    static int K;
    static ArrayList<Position> list;
    static boolean[][] arr;

    static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer tokens = new StringTokenizer(br.readLine());
            M = Integer.parseInt(tokens.nextToken());
            N = Integer.parseInt(tokens.nextToken());
            K = Integer.parseInt(tokens.nextToken());

            arr = new boolean[N][M];
            list = new ArrayList<>();
            for(int k = 0; k < K; k++) {
                tokens = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(tokens.nextToken());
                int r = Integer.parseInt(tokens.nextToken());
                list.add(new Position(r,c));
                arr[r][c] = true;
            }
            bw.write(bfs()+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isIn(int r, int c){
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    public static int bfs() {
        boolean[][] visited = new boolean[N][M];
        Queue<Position> q = new LinkedList<>();

        int count = 0;
        for(int k = 0; k < K; k++) {
            Position kth = list.get(k);
            if(visited[kth.r][kth.c]) continue;

            count++;
            q.offer(kth);
            visited[kth.r][kth.c] = true;

            while(!q.isEmpty()) {
                Position p = q.poll();

                for(int[] d : deltas) {
                    int nr = p.r + d[0];
                    int nc = p.c + d[1];
                    if(isIn(nr, nc) && !visited[nr][nc] && arr[nr][nc]) {
                        visited[nr][nc] = true;
                        q.offer(new Position(nr, nc));
                    }
                }
            }
        }
        return count;
    }
}
