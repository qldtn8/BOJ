package BJ.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15654_N과M5 {

    static int N, M;
    static int[] sequence;
    static StringBuilder output;

    public static void permutation(int nth, int[] choosed, int flag) {
        if(nth == M) {
            for(int i = 0; i < M; i++) {
                output.append(choosed[i]+" ");
            }
            output.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if((flag & 1 << i) == 0) {
                choosed[nth] = sequence[i];
                permutation(nth+1, choosed, flag | 1 << i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        output = new StringBuilder();

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());
        sequence = new int[N];
        for(int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(sequence);

        permutation(0, new int[M], 0);
        System.out.println(output);
    }
}
