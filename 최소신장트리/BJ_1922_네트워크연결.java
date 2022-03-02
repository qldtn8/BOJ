package BJ.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1922_네트워크연결 {

    static class Line implements Comparable<Line>{
        int from, to, cost;
        public Line(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Line o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int N, M;
    static Line[] lines;
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
        int xRoot = findSet(x);
        int yRoot = findSet(y);
        if(xRoot == yRoot) return false;
        parents[yRoot] = xRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        lines = new Line[M];

        StringTokenizer token;
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            lines[i] = new Line(Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken()));
        }
        Arrays.sort(lines);
        makeSet();

        int total = 0;
        int count = 0;
        for(Line line : lines) {
            if(unionSet(line.from, line.to)) {
                count++;
                total += line.cost;
            }
            if(count == N-1) break;
        }
        System.out.println(total);
    }
}
