package BJ.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1647_도시분할계획 {

    static class Road implements Comparable<Road>{
        int from, to, expenses;
        public Road(int from, int to, int expenses) {
            this.from = from;
            this.to = to;
            this.expenses = expenses;
        }
        @Override
        public int compareTo(Road o) {
            return Integer.compare(this.expenses, o.expenses);
        }
    }

    static int N, M;
    static PriorityQueue<Road> pq;
    static int[] parents;

    public static void makeSet() {
        parents = new int[N];
        for(int i = 0; i < N; i++) {
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
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        pq = new PriorityQueue<>();

        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            pq.offer(new Road(Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())));
        }

        makeSet();
        int total = 0;
        int count = 0;
        while(!pq.isEmpty()) {
            Road road = pq.poll();
            if(unionSet(road.from, road.to)) {
                count++;
                total += road.expenses;
            }
            if(count == N-2) break;
        }
        System.out.println(total);
    }
}

/*
public class BJ_1647_도시분할계획 {

    static class Road implements Comparable<Road>{
        int from, to, expenses;
        public Road(int from, int to, int expenses) {
            this.from = from;
            this.to = to;
            this.expenses = expenses;
        }
        @Override
        public int compareTo(Road o) {
            return Integer.compare(this.expenses, o.expenses);
        }
    }

    static int N, M;
    static Road[] roads;
    static int[] parents;

    public static void makeSet() {
        parents = new int[N];
        for(int i = 0; i < N; i++) {
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
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        roads = new Road[M];

        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            roads[i] = new Road(Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken()));
        }
        Arrays.sort(roads);

        makeSet();
        int total = 0;
        int count = 0;
        for(Road road : roads) {
            if(unionSet(road.from, road.to)) {
                count++;
                total += road.expenses;
            }
            if(count == N-2) break;
        }
        System.out.println(total);
    }
}
 */

