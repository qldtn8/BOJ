package BJ.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1368_물대기 {

    static class Vertex implements  Comparable<Vertex>{
        int no, cost;
        public Vertex(int no, int cost) {
            this.no = no;
            this.cost = cost;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] w = new int[N];
        int start = 0;
        int[] minEdge = new int[N];
        for(int i = 0; i < N; i++) {
            w[i] = Integer.parseInt(br.readLine());
            if(w[i] < w[start]) {
                start = i;
            }
            minEdge[i] = Integer.MAX_VALUE;
        }

        int[][] p = new int[N][N];
        for(int r = 0; r < N; r++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                p[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N];
        minEdge[start] = 0;
        int cost = w[start];

        pq.offer(new Vertex(start, minEdge[start]));
        for(int i = 0; i < N; i++) {

            Vertex v;
            while(true) {
                v = pq.poll();
                if(!visited[v.no]) break;
            }

            visited[v.no] = true;
            cost += v.cost;

            for(int j = 0; j < N; j++) {
                if(!visited[j] && ( minEdge[j] > w[j] || minEdge[j] > p[v.no][j])) {
                    minEdge[j] = Math.min(w[j], p[v.no][j]);
                    pq.offer(new Vertex(j, minEdge[j]));
                }
            }
        }
        System.out.println(cost);
    }
}
