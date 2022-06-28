package BJ.트리그래프;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2644_촌수계산 {

    static int N, M;
    static int start, end;

    static ArrayList<Integer>[] rel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer token = new StringTokenizer(br.readLine());
        start = Integer.parseInt(token.nextToken());
        end = Integer.parseInt(token.nextToken());

        rel = new ArrayList[N+1];

        M = Integer.parseInt(br.readLine());
        for(int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(token.nextToken());
            int child = Integer.parseInt(token.nextToken());

            if(rel[parent] == null) rel[parent] = new ArrayList<>();
            if(rel[child] == null) rel[child] = new ArrayList<>();

            rel[parent].add(child);
            rel[child].add(parent);
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        queue.offer(start);
        visited[start] = true;

        int degree = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int num = queue.poll();

                if(num == end) {
                    return degree;
                }

                if(rel[num] == null) continue;

                for(Integer next : rel[num]) {
                    if(!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            degree++;
        }
        return -1;
    }
}
