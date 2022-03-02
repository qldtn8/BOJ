package BJ.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_6497_전력난 {

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
    static PriorityQueue<Edge> pq;
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
        int xR = findSet(x);
        int yR = findSet(y);
        if(xR == yR) return false;
        parents[yR] = xR;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        while(true) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            V = Integer.parseInt(token.nextToken());
            E = Integer.parseInt(token.nextToken());

            if(V == 0 && E == 0) break;

            pq = new PriorityQueue<>();
            int result = 0;
            for(int i = 0; i < E; i++) {
                token = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(token.nextToken());
                int to = Integer.parseInt(token.nextToken());
                int weight = Integer.parseInt(token.nextToken());
                pq.add(new Edge(from, to, weight));

                result += weight;
            }

            makeSet();

            int count = 0;
            while(!pq.isEmpty()) {
                Edge e = pq.poll();
                if(unionSet(e.from, e.to)) {
                    result -= e.weight;
                    if(++count == V-1) break;
                }
            }
            output.append(result+"\n");
        }
        System.out.println(output);
    }
}
