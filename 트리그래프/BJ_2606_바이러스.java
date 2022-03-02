package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2606_바이러스 {

    static int N;   // 컴퓨터 개수
    static int M;   // 간선 수
    static boolean[] visit;
    static boolean[][] network;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        network = new boolean[N+1][N+1];
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            network[a][b] = true;
            network[b][a] = true;
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        int total = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visit[1] = true;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            for(int i = 1; i < N+1; i++) {
                if(network[temp][i] && !visit[i]) {
                    visit[i] = true;
                    queue.offer(i);
                    total++;
                }
            }
        }
        return total;
    }
}
