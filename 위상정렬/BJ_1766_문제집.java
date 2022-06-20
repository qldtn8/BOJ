package BJ.위상정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1766_문제집 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[] count = new int[N+1];
        ArrayList<Integer>[] relation = new ArrayList[N+1];

        for(int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            count[b]++;
            if(relation[a] == null) relation[a] = new ArrayList<>();
            relation[a].add(b);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= N; i++) {
            if(count[i] == 0) pq.offer(i);
        }

        while(!pq.isEmpty()) {
            int no = pq.poll();
            bw.write(no+" ");

            if(relation[no] == null) continue;

            for(Integer next : relation[no]) {
                if(--count[next] == 0) {
                    pq.offer(next);
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
