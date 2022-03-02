package BJ.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1504_특정한최단경로 {

    static class Vertex implements Comparable<Vertex> {
        int index, d;
        public Vertex(int index, int d) {
            this.index = index;
            this.d = d;
        }
        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.d, o.d);
        }
    }

    static int N;
    static int[][] adjMatrix;

    public static int dijkstra(int start, int end) {
        int[] distance = new int[N];
        boolean[] visited = new boolean[N];
        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.offer(new Vertex(start, distance[start]));

        int result = -1;
        while(!pq.isEmpty()) {
            Vertex current = pq.poll();
            if(visited[current.index]) continue;

            if(current.index == end) {
                result = current.d;
                break;
            }

            visited[current.index] = true;

            for(int i = 0; i < N; i++) {
                if(!visited[i] && adjMatrix[current.index][i] != 0 && distance[i] > current.d + adjMatrix[current.index][i]) {
                    distance[i] = current.d + adjMatrix[current.index][i];
                    pq.offer(new Vertex(i, distance[i]));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        int E = Integer.parseInt(token.nextToken());

        adjMatrix = new int[N][N];
        for(int e = 0; e < E; e++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken())-1;
            int b = Integer.parseInt(token.nextToken())-1;
            int c = Integer.parseInt(token.nextToken());
            if(adjMatrix[a][b] == 0) {
                adjMatrix[a][b] = c;
                adjMatrix[b][a] = c;
            } else {
                int min = Math.min(adjMatrix[a][b], c);
                adjMatrix[a][b] = min;
                adjMatrix[b][a] = min;
            }
        }

        token = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(token.nextToken())-1;
        int v2 = Integer.parseInt(token.nextToken())-1;

        int d1 = dijkstra(0, v1);
        int d2 = dijkstra(v1, v2);
        int d3 = dijkstra(v2, N-1);

        int d4 = dijkstra(0, v2);
        int d5 = dijkstra(v2, v1);
        int d6 = dijkstra(v1, N-1);

        if(d1 != -1 && d2 != -1 && d3 != -1 && d4 != -1 && d5 != -1 && d6 != -1) {
            System.out.println(Math.min(d1 + d2 + d3, d4 + d5 + d6));
        } else if(d1 != -1 && d2 != -1 && d3 != -1) {
            System.out.println(d1 + d2 + d3);
        } else if(d4 != -1 && d5 != -1 && d6 != -1) {
            System.out.println(d4 + d5 + d6);
        } else {
            System.out.println(-1);
        }
    }
}
