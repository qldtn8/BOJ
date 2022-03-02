package BJ.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1774_우주신과의교감 {

    static class Edge implements Comparable<Edge>{
        int from, to;
        double weight;
        public Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    static int V, E;
    static double[][] vertexes;
    static int[] parents;
    static PriorityQueue<Edge> pq;

    public static void makeSet() {
        parents = new int[V];
        for(int i = 0; i < V; i++) {
            parents[i] = i;
        }
    }

    public static int findSet(int x) {
        if(x == parents[x]) return x;
        return parents[x] = findSet(parents[x]);
    }

    public static boolean unionSet(int x, int y) {
        int xRoot = findSet(x);
        int yRoot = findSet(y);
        if(xRoot == yRoot) return false;
        parents[yRoot] = xRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        V = Integer.parseInt(token.nextToken());
        E = Integer.parseInt(token.nextToken());
        vertexes = new double[V][2];
        pq = new PriorityQueue<>();

        for(int i = 0; i < V; i++) {
            token = new StringTokenizer(br.readLine());
            vertexes[i][0] = Double.parseDouble(token.nextToken());
            vertexes[i][1] = Double.parseDouble(token.nextToken());

            for(int j = 0; j < i; j++) {
                double x = Math.pow(vertexes[j][0] - vertexes[i][0], 2);
                double y = Math.pow(vertexes[j][1] - vertexes[i][1], 2);
                double distance = Math.pow(x+y, 0.5);
                pq.offer(new Edge(i, j, distance));
            }
        }

        makeSet();
        int count = 0;
        for(int i = 0; i < E; i++) {
            token = new StringTokenizer(br.readLine());
            unionSet(Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())-1);
            count++;
        }

        double result = 0;
        while(!pq.isEmpty()) {
            if(count == V-1) {
                break;
            }
            Edge edge = pq.poll();
            if(unionSet(edge.from, edge.to)) {
                count++;
                result += edge.weight;
            }
        }
        System.out.printf("%.2f", result);
    }
}
