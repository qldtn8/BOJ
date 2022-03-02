package BJ.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1197_최소스패닝트리 {

    static class Edge implements Comparable<Edge>{
        int from, to, weight;
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int V, E;
    static Edge[] edges;
    static int[] parents;

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
        edges = new Edge[E];

        for(int i = 0; i < E; i++) {
            token = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken()));
        }
        Arrays.sort(edges);

        makeSet();

        int total = 0;
        int count = 0;
        for(Edge edge : edges) {
            if(unionSet(edge.from, edge.to)) {
                count++;
                total += edge.weight;
            }
            if(count == V-1) break;
        }
        System.out.println(total);
    }
}
