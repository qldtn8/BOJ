package BJ.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_4386_별자리만들기 {

    static class Vertex implements Comparable<Vertex>{
        int index;
        double cost;
        public Vertex(int index, double cost) {
            this.index = index;
            this.cost = cost;
        }
        @Override
        public int compareTo(Vertex o) {
            return Double.compare(this.cost, o.cost);
        }
    }

    static int N;
    static double[][] location;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        location = new double[N][2];
        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            location[i][0] = Double.parseDouble(token.nextToken());
            location[i][1] = Double.parseDouble(token.nextToken());
        }


        double[] minEdge = new double[N];
        boolean[] visited = new boolean[N];
        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        Arrays.fill(minEdge, Double.MAX_VALUE);
        minEdge[0] = 0;
        pq.add(new Vertex(0, minEdge[0]));

        double result = 0.0;
        while(!pq.isEmpty()) {

            Vertex v = pq.poll();
            if(visited[v.index]) continue;

            visited[v.index] = true;
            result += v.cost;
            for(int i = 0; i < N; i++) {
                if(!visited[i]) {
                    double x = Math.pow(location[v.index][0] - location[i][0], 2);
                    double y = Math.pow(location[v.index][1] - location[i][1], 2);
                    double d = Math.pow(x+y, 0.5);
                    if(minEdge[i] > d) {
                        minEdge[i] = d;
                        pq.add(new Vertex(i, minEdge[i]));
                    }
                }
            }
        }
        System.out.printf("%.2f", result);
    }
}
