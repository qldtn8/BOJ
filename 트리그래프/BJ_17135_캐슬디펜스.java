package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_17135_캐슬디펜스 {

    static class Position implements Comparable<Position>{
        int r, c, idx, depth;
        public Position(int r, int c, int idx, int depth) {
            this.r = r;
            this.c = c;
            this.idx = idx;
            this.depth = depth;
        }

        @Override
        public int compareTo(Position o) {
            if(this.depth != o.depth)
                return this.depth - o.depth;
            if(this.c != o.c)
                return this.c - o.c;
            return this.r - o.r;
        }

//        @Override
//        public String toString() {
//            return "Position{" +
//                    "r=" + r +
//                    ", c=" + c +
//                    ", idx=" + idx +
//                    ", depth=" + depth +
//                    '}';
//        }
    }

    static int N, M, D;
    static int[][] map;
    static int[][] copy;

    static int max;
    static int count;

    static int[][] deltas = {{0, -1},{0, 1},{-1, 0}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    public static void setPosition(int choose, int start, int[] archer) {
        if(choose == 3) {
            attack(archer);
            return;
        }
        for(int i = start; i < M; i++) {
            archer[choose] = i;
            setPosition(choose+1, i + 1, archer);
        }
    }

    public static void attack(int[] archer) {
        count = 0;
        copy = new int[N][M];
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                copy[r][c] = map[r][c];
            }
        }
        int row = N;
        while(row > 0) {
            count += bfs(row-1, archer);
            copy[--row] = new int[M];
        }
        max = Math.max(max, count);
    }

    private static int bfs(int row, int[] archer) {
//        System.out.println("bfs--------");
        PriorityQueue<Position> pq = new PriorityQueue<>();
        boolean[] success = new boolean[3];
        pq.offer(new Position(row, archer[0], 0, 1));
        pq.offer(new Position(row, archer[1], 1, 1));
        pq.offer(new Position(row, archer[2], 2, 1));

        boolean[][] visited = new boolean[N][M];
        while(!pq.isEmpty()) {
//            System.out.println("\t"+pq);
            Position p = pq.poll();
            if(success[p.idx]) continue;

            if(copy[p.r][p.c] == 1) {
                success[p.idx] = true;
                visited[p.r][p.c] = true;
                if(success[0] && success[1] && success[2]) break;
                continue;
            }

            for(int[] d : deltas) {
                int nr = p.r + d[0];
                int nc = p.c + d[1];
                if(isIn(nr, nc) && p.depth + 1 <= D) {
                    pq.offer(new Position(nr, nc, p.idx, p.depth+1));
                }
            }
        }
        int total = 0;
        for(int r = 0; r <= row; r++) {
            for(int c = 0; c < M; c++) {
                if(visited[r][c]) {
                    total++;
                    copy[r][c] = 0;
                }
//                System.out.print(copy[r][c] + " ");
            }
//            System.out.println();
        }
//        System.out.println("\n----------------");
        return total;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        D = Integer.parseInt(token.nextToken());
        map = new int[N][M];
        for(int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        max = Integer.MIN_VALUE;
        setPosition(0, 0, new int[3]);
        System.out.println(max);
    }
}
