package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_5014_스타트링크 {

    static int F, S, G, U, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        F = Integer.parseInt(token.nextToken());
        S = Integer.parseInt(token.nextToken());
        G = Integer.parseInt(token.nextToken());
        U = Integer.parseInt(token.nextToken());
        D = Integer.parseInt(token.nextToken());

        int count = bfs();
        System.out.println(count != -1 ? count : "use the stairs");
    }

    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[F+1];

        queue.offer(S);
        visited[S] = true;

        int degree = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                Integer floor = queue.poll();

                if(floor == G) return degree;

                if(floor + U <= F && !visited[floor+U]) {
                    visited[floor+U] = true;
                    queue.offer(floor+U);
                }
                if(floor - D > 0 && !visited[floor-D]) {
                    visited[floor-D] = true;
                    queue.offer(floor-D);
                }
            }
            degree++;
        }
        return -1;
    }
}
