package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 카드 합체 놀이
 */
public class BJ_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());
        int[] cards = new int[N];
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(token.nextToken());
        }

        for(int i = 0; i < M; i++) {
            Arrays.sort(cards);
            int sum = cards[0] + cards[1];
            cards[0] = sum;
            cards[1] = sum;
        }

        int total = 0;
        for(int i = 0; i < N; i++) {
            total += cards[i];
        }
        System.out.println(total);
    }
}
