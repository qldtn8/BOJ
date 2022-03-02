package BJ.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1182_부분수열의합 {

    static int N;
    static int S;
    static int[] numbers;
    static int total;

    public static void subSet(int nth, int sum, int flag) {
        if(nth == N) {
            if(flag != 0 && sum == S) {
                total++;
            }
            return;
        }
        subSet(nth + 1, sum + numbers[nth], flag | 1 << nth);
        subSet(nth + 1, sum, flag);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        S = Integer.parseInt(token.nextToken());

        numbers = new int[N];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(token.nextToken());
        }

        total = 0;
        subSet(0, 0, 0);
        System.out.println(total);
    }
}
