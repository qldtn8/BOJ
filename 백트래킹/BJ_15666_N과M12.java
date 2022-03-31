package BJ.백트래킹;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_15666_N과M12 {

    static int N, M;
    static int[] arr;
    static PriorityQueue<int[]> pq;
    static BufferedWriter bw;

    public static void combination(int nth, int start, int[] choosed) {
        if(nth == M) {
            pq.offer(Arrays.copyOf(choosed, M));
            return;
        }

        for(int i = start; i < N; i++) {
            choosed[nth] = arr[i];
            combination(nth+1, i, choosed);
        }
    }

    public static void printArr(int[] temp) throws IOException {
        for(int i = 0; i < M; i++) {
            bw.write(temp[i]+ " ");
        }
        bw.newLine();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        arr = new int[N];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);
        br.close();

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
        combination(0, 0, new int[M]);


        int[] prev = pq.poll();
        printArr(prev);
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            for(int i = 0; i < M; i++) {
                if(prev[i] != curr[i]) {
                    printArr(curr);
                    prev = curr;
                    continue;
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
