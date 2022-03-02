package BJ.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_16398_행성연결 {

    static class Vertex implements Comparable<Vertex>{
        int index, weight;
        public Vertex(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int N;
    static int[][] adjMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer token;
        adjMatrix = new int[N][N];
        int[] minEdge = new int[N];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                adjMatrix[i][j] = Integer.parseInt(token.nextToken());
            }
            minEdge[i] = Integer.MAX_VALUE;
        }

        boolean[] visited = new boolean[N];
        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        minEdge[0] = 0;
        pq.add(new Vertex(0, minEdge[0]));

        long result = 0;
        for(int i = 0; i < N; i++) {
            Vertex v;
            while(true) {
                v = pq.poll();
                if(!visited[v.index]) break;
            }

            visited[v.index] = true;
            result += v.weight;

            for(int j = 0; j < N; j++) {
                if(!visited[j] && minEdge[j] > adjMatrix[v.index][j]) {
                    minEdge[j] = adjMatrix[v.index][j];
                    pq.offer(new Vertex(j, minEdge[j]));
                }
            }
        }
        System.out.println(result);
    }
}

/*
// Kruskal
public class BJ_16398_행성연결 {

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

    static int N;
    static PriorityQueue<Edge> pq;
    static int[] parents;

    public static void makeSet() {
        parents = new int[N];
        for(int i = 0; i < N; i++)
            parents[i] = i;
    }

    public static int findSet(int x) {
        if(parents[x] == x) return x;
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
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < i; j++) {
                pq.add(new Edge(i, j, Integer.parseInt(token.nextToken())));
            }
        }

        makeSet();

        int count = 0;
        int result = 0;

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            if(unionSet(edge.from, edge.to)) {
                result += edge.weight;
            }
            if(++count == N-1) break;
        }
        System.out.println(result);
    }
}
 */