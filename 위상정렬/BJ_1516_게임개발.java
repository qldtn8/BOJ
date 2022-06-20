package BJ.위상정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1516_게임개발 {

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

        int N = Integer.parseInt(br.readLine());

        int[] count = new int[N+1];
        int[] time = new int[N+1];
        ArrayList<Integer>[] relation = new ArrayList[N+1];

        PriorityQueue<Construction> pq = new PriorityQueue<>();
        for(int i = 1; i <= N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(token.nextToken());

            if(token.countTokens() == 1) {
                pq.offer(new Construction(i, time[i]));
            } else {
                while(token.hasMoreTokens()) {
                    int no = Integer.parseInt(token.nextToken());
                    if(no == -1) break;

                    count[i]++;
                    if(relation[no] == null) relation[no] = new ArrayList<>();
                    relation[no].add(i);
                }
            }
        }

        while(!pq.isEmpty()) {
            Construction c = pq.poll();
            time[c.no] = c.time;

            if(relation[c.no] == null) continue;
            for(Integer next : relation[c.no]) {
                if(--count[next] == 0) pq.offer(new Construction(next, c.time + time[next]));
            }
        }

        for(int i = 1; i <= N; i++) {
            bw.write(time[i]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
