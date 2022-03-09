package BJ.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_15663_N과M9 {

    static int N, M;
    static int[] arr;
    static StringBuilder output;
    static PriorityQueue<int[]> pq;
    static int[] pre;

    public static void permutation(int nth, int[] choosed, int flag) {
        if(nth == M) {
            int[] newArr = Arrays.copyOf(choosed, M);
            pq.offer(newArr);
            return;
        }
        for(int i = 0; i < N; i++) {
            if((flag & 1 << i) == 0) {
                choosed[nth] = arr[i];
                permutation(nth+1, choosed,flag | 1 << i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        output = new StringBuilder();
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        arr = new int[N];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);

        pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for(int i = 0; i < o1.length; i++) {
                    if(o1[i] != o2[i]) {
                        return o1[i] - o2[i];
                    }
                }
                return 0;
            }
        });

        permutation(0, new int[M],0);

        pre = pq.poll();
        for(int num : pre) {
            output.append(num + " ");
        }
        output.append("\n");
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            boolean isDup = true;
            for(int i = 0; i < M; i++) {
                if(pre[i] != curr[i]) {
                    isDup = false;
                    break;
                }
            }
            if(isDup) continue;

            pre = curr;
            for(int num : curr) {
                output.append(num + " ");
            }
            output.append("\n");
        }

        System.out.println(output);

    }
}
