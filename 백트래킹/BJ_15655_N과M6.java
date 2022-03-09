package BJ.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15655_N과M6 {

    static int N, M;
    static int[] arr;
    static StringBuilder output;

    public static void permutation(int nth, int start , int flag) {
        if(nth == M) {
            for(int i = 0; i < N; i++) {
                if((flag & 1 << i) != 0) {
                    output.append(arr[i] + " ");
                }
            }
            output.append("\n");
            return;
        }
        for(int i = start; i < N; i++) {
            if((flag & 1 << i) == 0) {
                permutation(nth+1, i+1, flag | 1 << i);
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

        permutation(0, 0, 0);
        System.out.println(output);

    }
}
