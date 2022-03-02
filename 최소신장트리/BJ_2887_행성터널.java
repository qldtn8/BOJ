package BJ.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2887_행성터널 {

    static class Planet implements Comparable<Planet> {
        int index, cost;
        public Planet(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
        @Override
        public int compareTo(Planet o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int N;
    static int[][] planets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        planets = new int[N][3];
        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            planets[i][0] = Integer.parseInt(token.nextToken());
            planets[i][1] = Integer.parseInt(token.nextToken());
            planets[i][2] = Integer.parseInt(token.nextToken());
        }

        int[] minEdge = new int[N];
        PriorityQueue<Planet> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N];

        Arrays.fill(minEdge, Integer.MAX_VALUE);
        minEdge[0] = 0;
        pq.offer(new Planet(0, 0));

        int total = 0;
        for(int i = 0; i < N; i++) {
            // 방문하지 않았고 비용이 가장 최소인 정점을 선택
            Planet p ;
            while(true) {
                p = pq.poll();
                if(!visited[p.index]) break;
            }

            // 방문처리 및 비용에 추가
            visited[p.index] = true;
            total += p.cost;

            // 방문하지 않은 행성들까지 거리가 다른 거리보다 짧다면 변경 후 pq에 추가
            for(int j = 0; j < N; j++) {
                if(!visited[j]) {
                    int a = Math.abs(planets[p.index][0]-planets[j][0]);
                    int b = Math.abs(planets[p.index][1]-planets[j][1]);
                    int c = Math.abs(planets[p.index][2]-planets[j][2]);
                    int minCost = Math.min(a, Math.min(b, c));
                    if(minEdge[j] > minCost) {
                        minEdge[j] = minCost;
                        pq.offer(new Planet(j, minCost));
                    }
                }
            }
        }
        System.out.println(total);
    }
}

/*
public class BJ_2887_행성터널 {

    static class Planet implements Comparable<Planet> {
        int index;
        int cost;
        public Planet(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
        @Override
        public int compareTo(Planet o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int N;
    static int[][] planets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        planets = new int[N][3];
        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            planets[i][0] = Integer.parseInt(token.nextToken());
            planets[i][1] = Integer.parseInt(token.nextToken());
            planets[i][2] = Integer.parseInt(token.nextToken());
        }


        PriorityQueue<Planet> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N];
        pq.offer(new Planet(0, 0));

        int total = 0;
        for(int i = 0; i < N; i++) {
            // 방문하지 않았고 비용이 가장 최소인 정점을 선택
            Planet p ;
            while(true) {
                p = pq.poll();
                if(!visited[p.index]) break;
            }

            // 방문처리 및 비용에 추가
            visited[p.index] = true;
            total += p.cost;

            // 방문하지 않은 행성들까지 거리를 계산해서 pq에 추가
            for(int j = 0; j < N; j++) {
                if(j != p.index && !visited[j]) {
                    int a = Math.abs(planets[p.index][0]-planets[j][0]);
                    int b = Math.abs(planets[p.index][1]-planets[j][1]);
                    int c = Math.abs(planets[p.index][2]-planets[j][2]);
                    int minCost = Math.min(a, Math.min(b, c));
                    pq.offer(new Planet(j, minCost));
                }
            }
        }
        System.out.println(total);
    }
}
 */
