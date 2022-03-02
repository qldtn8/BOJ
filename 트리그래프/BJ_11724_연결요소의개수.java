package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11724_연결요소의개수 {

    static int N, M;
    static int[] parents;

    public static void makeSet() {
        parents = new int[N];
        for(int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    public static int findSet(int x) {
        if(parents[x] == x) {
            return x;
        }
        return parents[x] = findSet(parents[x]);
    }

    public static void union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot != bRoot) {
            parents[bRoot] = aRoot;
        }
    }

    public static int numOf() {
        int total = 0;
        for(int i = 0; i < N; i++) {
            if(parents[i] == i) total++;
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        makeSet();
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            union(Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())-1);
        }
        System.out.println(numOf());
    }
}
