package BJ.위상정렬;

import java.io.*;
import java.util.*;

public class BJ_2252_줄세우기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        LinkedList<Integer>[] relation = new LinkedList[N+1];
        int[] sort = new int[N+1];
        for(int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            if(relation[a] == null) relation[a] = new LinkedList<>();
            relation[a].add(b);
            sort[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(sort[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int item = queue.poll();
            bw.write(item+" ");

            if(relation[item] == null) continue;
            for(int i = 0; i < relation[item].size(); i++) {
                int temp = relation[item].get(i);
                sort[temp]--;
                if(sort[temp] == 0) {
                    queue.offer(temp);
                    relation[item].remove(i--);
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
