package BJ.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_4485_녹색옷입은애가젤다지 {

    static class Position implements Comparable<Position> {
        int r, c, d;
        public Position(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
        @Override
        public int compareTo(Position o) {
            return Integer.compare(this.d, o.d);
        }
    }

    static int N;
    static int[][] arr;
    static int[][] distance;
    static boolean[][] visited;

    static int[][] deltas = {{1, 0},{-1, 0},{0, 1},{0, -1}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    public static int dijkstra() {
        PriorityQueue<Position> pq = new PriorityQueue<>();

        distance[0][0] = arr[0][0];
        pq.offer(new Position(0, 0, distance[0][0]));

        int result = 0;
        while(!pq.isEmpty()) {
            Position curr = pq.poll();
            if(visited[curr.r][curr.c]) continue;

            if(curr.r == N-1 && curr.c == N-1) {
                result = curr.d;
                break;
            }

            visited[curr.r][curr.c] = true;

            for(int d = 0; d < deltas.length; d++) {
                int nr = curr.r + deltas[d][0];
                int nc = curr.c + deltas[d][1];
                if(isIn(nr, nc) && !visited[nr][nc] && distance[nr][nc] > curr.d + arr[nr][nc]) {
                    distance[nr][nc] = curr.d + arr[nr][nc];
                    pq.offer(new Position(nr, nc, distance[nr][nc]));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int t = 1;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) {
                break;
            }

            arr = new int[N][N];
            distance = new int[N][N];
            visited = new boolean[N][N];
            StringTokenizer token;
            for(int i = 0; i < N; i++) {
                token = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(token.nextToken());
                    distance[i][j] = Integer.MAX_VALUE;
                    visited[i][j] = false;
                }
            }
            int result = dijkstra();
            output.append("Problem "+(t++)+": "+result+"\n");
        }
        System.out.println(output);
    }
}
