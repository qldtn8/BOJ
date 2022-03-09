package BJ.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15657_N과M8 {

    static int N, M;
    static int[] arr;

    static StringBuilder output;

    public static void combination(int nth, int start, int[] choosed) {
        if (nth == M) {
            for (int data : choosed) {
                output.append(data+" ");
            }
            output.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            choosed[nth] = arr[i];
            combination(nth+1, i, choosed);
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


        combination(0, 0, new int[M] );
        System.out.println(output);
    }
}
