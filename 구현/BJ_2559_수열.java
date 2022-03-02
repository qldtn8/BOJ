package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2559_수열 {

    static int N, K;
    static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        temp = new int[N];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(token.nextToken());
        }

        int start = 0;
        int end = K-1;
        int sum = 0;
        for(int i = start; i <= end; i++) {
            sum += temp[i];
        }
        int max = sum;
        start++; end++;

        while(end < N) {
            sum -= temp[start++ - 1];
            sum += temp[end++];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
