package BJ.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11047_동전0 {

    static int N, K;
    static int[] weight;
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        weight = new int[N];
        for(int i = N-1; i >= 0; i--) {
            weight[i] = Integer.parseInt(br.readLine());
        }
        total = 0;
        for(int i = 0; i < N; i++) {
            if(K - weight[i] < 0) continue;
            total += K / weight[i];
            K %= weight[i];

            if(K == 0) break;
        }
        System.out.println(total);
    }
}
