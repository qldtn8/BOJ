package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260_DFS와BFS {

    static int N;
    static int M;
    static int V;

    static boolean[][] graph;
    static boolean[] visit;

    static StringBuilder output;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        output = new StringBuilder();
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        V = Integer.parseInt(token.nextToken());
        graph = new boolean[N+1][N+1];

        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            graph[a][b] = true;
            graph[b][a] = true;
        }
        visit = new boolean[N+1];
        dfs(V);
        output.append("\n");
        visit = new boolean[N+1];
        bfs();
        System.out.println(output.toString());
    }

    public static void dfs(int vertex) {
        output.append(vertex + " ");
        visit[vertex] = true;
        for(int i = 1; i < N+1; i++) {
            if(graph[vertex][i] && !visit[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        visit[V] = true;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            output.append(temp + " ");

            for(int i = 1; i < N+1; i++) {
                if(graph[temp][i] && !visit[i]) {
                    visit[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
