package BJ.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1238_파티 {

    static int N;
    static int[][] adjMatrix;

    public static int[] dijkstra(int start, int end) {
        int[] d = new int[N];
        boolean[] visited = new boolean[N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[1], o2[1]));

        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;
        pq.offer(new int[]{start, d[start]});

        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            if(visited[current[0]]) continue;

            if(current[0] == end) {
                return d;
            }

            visited[current[0]] = true;

            for(int i = 0; i < d.length; i++) {
                if(!visited[i] && adjMatrix[current[0]][i] != 0 && d[i] > current[1] + adjMatrix[current[0]][i]) {
                    d[i] = current[1] + adjMatrix[current[0]][i];
                    pq.offer(new int[]{i, d[i]});
                }
            }
        }
        return d;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int X = Integer.parseInt(token.nextToken());

        adjMatrix = new int[N][N];
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken())-1;
            int b = Integer.parseInt(token.nextToken())-1;
            int c = Integer.parseInt(token.nextToken());
            adjMatrix[a][b] = c;
        }
        // 입력 끝-------------------------------


        int[] distance = new int[N];
        for(int i = 0; i < N; i++) {
            distance[i] = dijkstra(i, X-1)[X-1];
        }
        int[] temp = dijkstra(X-1, N);

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            if(max < distance[i]+temp[i]) {
                max = distance[i]+temp[i];
            }
        }
        System.out.println(max);
    }
}
