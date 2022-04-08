package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14502_연구소 {

    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M;
    static int[][] map;

    //static int totalScope;
    static int maxScope;
    static ArrayList<Point> list = new ArrayList<>();
    static ArrayList<Point> virus = new ArrayList<>();

    static int[][] deltas = {{-1, 0},{1, 0},{0, 1},{0, -1}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    public static void combination(int choose, int start) {
        if(choose == 3) {
//            int scope = bfs();
//            maxScope = Math.max(maxScope, totalScope - scope - 3);
            int[][] copyMap = new int[N][M];
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < M; c++)
                    copyMap[r][c] = map[r][c];
            }
            for(Point v : virus) {
                dfs(v.r, v.c, copyMap);
            }
            int count = 0;
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < M; c++)
                    if(copyMap[r][c] == 0) count++;
            }
            maxScope = Math.max(maxScope, count);
            return;
        }

        for(int i = start; i < list.size(); i++) {
            Point p = list.get(i);
            map[p.r][p.c] = 1;
            combination(choose + 1, i+1);
            map[p.r][p.c] = 0;
        }
    }

    public static void dfs(int r, int c, int[][] copy) {
        for(int d = 0; d < deltas.length; d++) {
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];
            if(isIn(nr, nc) && copy[nr][nc] == 0) {
                copy[nr][nc] = 2;
                dfs(nr, nc, copy);
            }
        }
    }

//    public static int bfs() {
//        Queue<Point> queue = new LinkedList<>();
//        for(Point p : virus) {
//            queue.offer(p);
//        }
//
//        boolean[][] visited = new boolean[N][M];
//        for(Point p : virus) {
//            visited[p.r][p.c] = true;
//        }
//
//        int count = 0;
//        while(!queue.isEmpty()) {
//            Point p = queue.poll();
//
//            for(int d = 0; d < deltas.length; d++) {
//                int nr = p.r + deltas[d][0];
//                int nc = p.c + deltas[d][1];
//
//                if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 0) {
//                    count++;
//                    visited[nr][nc] = true;
//                    queue.offer(new Point(nr, nc));
//                }
//            }
//        }
//        return count;
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[N][M];
        for(int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
                if(map[r][c] == 0) {
                    //totalScope++;
                    list.add(new Point(r, c));
                }
                else if(map[r][c] == 2) virus.add(new Point(r, c));
            }
        }
        maxScope = Integer.MIN_VALUE;
        combination(0, 0);
        System.out.println(maxScope);
    }
}
