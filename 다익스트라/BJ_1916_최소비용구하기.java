package BJ.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1916_최소비용구하기 {

    static class Vertex implements Comparable<Vertex> {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] adjMatrix = new int[N][N];
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                adjMatrix[r][c] = -1;
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer token;
        for(int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken())-1;
            int b = Integer.parseInt(token.nextToken())-1;
            int cost = Integer.parseInt(token.nextToken());
            if(adjMatrix[a][b] == -1) {
                adjMatrix[a][b] = cost;
            } else {
                adjMatrix[a][b] = Math.min(cost, adjMatrix[a][b]);
            }
        }

        token = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(token.nextToken()) -1;
        int end = Integer.parseInt(token.nextToken()) -1;
        // 입력 끝---------------------------------


        int[] distance = new int[N];
        boolean[] visited = new boolean[N];
        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.add(new Vertex(start, distance[start]));

        int result = 0;
        while(!pq.isEmpty()) {
            Vertex v = pq.poll();
            if(visited[v.index]) continue;

            if(v.index == end) {
                result = distance[v.index];
                break;
            }
            visited[v.index] = true;

            for(int i = 0; i < distance.length; i++) {
                if(!visited[i] && adjMatrix[v.index][i] != -1 && distance[i] > v.weight + adjMatrix[v.index][i]) {
                    distance[i] = v.weight + adjMatrix[v.index][i];
                    pq.offer(new Vertex(i, distance[i]));
                }
            }

        }
        System.out.println(result);
    }
}
