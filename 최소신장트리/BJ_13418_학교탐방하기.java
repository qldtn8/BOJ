package BJ.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_13418_학교탐방하기 {

    static class Edge {
        int a, b, c;
        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static int N, M;
    static int[] parents;

    public static void makeSet() {
        parents = new int[N];
        for(int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    public static int findSet(int x) {
        if(x == parents[x]) {
            return x;
        }
        return parents[x] = findSet(parents[x]);
    }

    public static boolean unionSet(int a, int b) {
        int rootA = findSet(a);
        int rootB = findSet(b);
        if(rootA == rootB) return false;
        parents[rootB] = rootA;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken()) + 1;
        M = Integer.parseInt(token.nextToken());
        ArrayList<Edge> edges = new ArrayList<>();
        int k = 0;
        for(int i = 0; i < M+1; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());
            if(i == 0) {
                if(c == 0) {
                    k++;
                }
            } else {
                edges.add(new Edge(a, b, c));
            }
        }

        int k_max = k;
        makeSet();
        Collections.sort(edges, ((o1, o2) -> o2.c-o1.c));
        int count = 0;
        for(Edge e : edges) {
            if(unionSet(e.a, e.b)) {
                if(e.c == 0) k++;
                if(++count == N-2) break;
            }
        }

        makeSet();
        Collections.sort(edges, ((o1, o2) -> o1.c-o2.c));
        count = 0;
        for(Edge e : edges) {
            if(unionSet(e.a, e.b)) {
                if(e.c == 0) k_max++;
                if(++count == N-2) break;
            }
        }
        System.out.println(k_max*k_max - k*k);
    }
}


/*
public class BJ_13418_학교탐방하기 {

    static class Edge {
        int a, b, c;
        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static int N, M;
    static int[] parents;

    public static void makeSet() {
        parents = new int[N];
        for(int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    public static int findSet(int x) {
        if(x == parents[x]) {
            return x;
        }
        return parents[x] = findSet(parents[x]);
    }

    public static boolean unionSet(int a, int b) {
        int rootA = findSet(a);
        int rootB = findSet(b);
        if(rootA == rootB) return false;
        parents[rootB] = rootA;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken()) + 1;
        M = Integer.parseInt(token.nextToken());

        makeSet();
        PriorityQueue<Edge> pq1 = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o2.c - o1.c;
            }
        });
        PriorityQueue<Edge> pq2 = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.c - o2.c;
            }
        });
        int k1 = 0; // 피로도 최소
        int k2 = 0; // 피로도 최대
        for(int i = 0; i < M+1; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());
            if(i == 0) {
                if(c == 0) {
                    k1++;
                    k2++;
                }
            } else {
                pq1.offer(new Edge(a, b, c));
                pq2.offer(new Edge(a, b, c));
            }
        }

        int count = 0;
        while(!pq1.isEmpty()) {
            Edge e = pq1.poll();
            if(unionSet(e.a, e.b)) {
                if(e.c == 0) k1++;
                if(++count == N-2) break;
            }
        }

        makeSet();
        count = 0;
        while(!pq2.isEmpty()) {
            Edge e = pq2.poll();
            if(unionSet(e.a, e.b)) {
                if(e.c == 0) k2++;
                if(++count == N-2) break;
            }
        }
        System.out.println(k2*k2 - k1*k1);
    }
}
*/
