package BJ.위상정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1005_ACMCraft {

    static class Construction implements Comparable<Construction> {
        int no, time;
        public Construction(int no, int time) {
            this.no = no;
            this.time = time;
        }

        @Override
        public int compareTo(Construction o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(token.nextToken());
            int K = Integer.parseInt(token.nextToken());

            int[] delay = new int[N+1];
            token = new StringTokenizer(br.readLine());
            for(int d = 1; d <= N; d++) {
                delay[d] = Integer.parseInt(token.nextToken());
            }

            int[] count = new int[N+1];
            ArrayList<Integer>[] relation = new ArrayList[N+1];

            for(int k = 0; k < K; k++) {
                token = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(token.nextToken());
                int y = Integer.parseInt(token.nextToken());

                count[y]++;
                if(relation[x] == null) relation[x] = new ArrayList<>();
                relation[x].add(y);
            }

            PriorityQueue<Construction> pq = new PriorityQueue<>();
            for(int i = 1; i <= N; i++) {
                if(count[i] == 0) pq.offer(new Construction(i, delay[i]));
            }

            int W = Integer.parseInt(br.readLine());
            int result = 0;
            while(true) {
                Construction c = pq.poll();

                if(c.no == W) {
                    result = c.time;
                    break;
                }

                if(relation[c.no] == null) continue;

                for(Integer next : relation[c.no]) {
                    if(--count[next] == 0) {
                        pq.offer(new Construction(next, c.time+delay[next]));
                    }
                }
            }
            bw.write(result+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
