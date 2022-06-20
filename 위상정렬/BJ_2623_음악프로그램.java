package BJ.위상정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2623_음악프로그램 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        int[] count = new int[N+1];
        ArrayList<Integer>[] relation = new ArrayList[N+1];

        for(int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(token.nextToken());

            int prev = Integer.parseInt(token.nextToken());
            for(int i = 0; i < len-1; i++) {
                int curr = Integer.parseInt(token.nextToken());
                count[curr]++;
                if(relation[prev] == null) relation[prev] = new ArrayList<>();
                relation[prev].add(curr);

                prev = curr;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int n = 1; n <= N; n++) {
            if(count[n] == 0) queue.offer(n);
        }


        ArrayList<Integer> output = new ArrayList<>();
        while(!queue.isEmpty()) {
            int singer = queue.poll();
            output.add(singer);

            if(relation[singer] == null) continue;
            for(Integer next : relation[singer]) {
                if(--count[next] == 0) queue.offer(next);
            }
        }

        if(output.size() != N) {
            bw.write("0");
        } else {
            for(Integer singer : output) {
                bw.write(singer+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
