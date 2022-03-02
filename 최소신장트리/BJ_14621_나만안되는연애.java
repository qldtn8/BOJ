package BJ.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_14621_나만안되는연애 {

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

    static int N, M;
    static char[] gender;
    static PriorityQueue<Edge> pq;
    static int[] parents;

    public static void makeSet() {
        parents = new int[N];
        for(int i = 0; i < N; i++)
            parents[i] = i;
    }

    public static int findSet(int x) {
        if(x == parents[x]) return x;
        return parents[x] = findSet(parents[x]);
    }

    public static boolean unionSet(int x, int y) {
        if(gender[x] == gender[y]) return false;
        int xRoot = findSet(x);
        int yRoot = findSet(y);
        if(xRoot == yRoot) return false;
        parents[yRoot] = xRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        gender = new char[N];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            gender[i] = token.nextToken().charAt(0);
        }

        pq = new PriorityQueue<>();
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            pq.add(new Edge(Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())));
        }

        makeSet();

        int count = 0;
        int result = 0;

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            if(unionSet(edge.from, edge.to)) {
                count++;
                result += edge.weight;
            }
            if(count == N-1) break;
        }
        System.out.println(count == N-1 ? result : -1);
    }
}
