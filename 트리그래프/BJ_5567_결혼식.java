package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_5567_결혼식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[][] relation = new boolean[N+1][N+1];
        for(int i = 0; i < M; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            relation[a][b] = true;
            relation[b][a] = true;
        }


        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        int count = 3;
        int numOf = -1;
        while(count-- > 0) {
            int size = queue.size();
            while(size-- > 0) {
                int idx = queue.poll();
                numOf++;
                for(int i = 1; i <= N; i++) {
                    if(!visited[i] && relation[idx][i]) {
                        visited[i] = true;
                        queue.offer(i);
                    }
                }
            }
        }
        System.out.println(numOf);
    }
}
