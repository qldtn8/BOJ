package BJ.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_15664_N과M10 {

    static int N, M;
    static int[] arr;
    static StringBuilder output;
    static PriorityQueue<int[]> pq;
    static int[] pre;

    public static void combination(int nth, int start, int flag) {
        if(nth == M) {
            int[] newArr = new int[M];
            int index = 0;
            for(int i = 0; i < N; i++) {
                if((flag & 1 << i) != 0) {
                    newArr[index++] = arr[i];
                }
            }
            pq.offer(newArr);
            return;
        }
        for(int i = start; i < N; i++) {
            if((flag & 1 << i) == 0) {
                combination(nth+1,i+1, flag | 1 << i);
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
                        return o1[i]-o2[i];
                    }
                }
                return 0;
            }
        });

        combination(0,0,0);

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
