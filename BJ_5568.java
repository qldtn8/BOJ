package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 카드 놓기
 */
public class BJ_5568 {

    static int N, K;
    static int[] card;
    static boolean[] isUsed;
    static Set<Integer> numbers;
    static StringBuilder number = new StringBuilder("");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        card = new int[N];
        isUsed = new boolean[N];
        numbers = new HashSet<>();

        for(int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(br.readLine());
        }

        permutation(0);
        System.out.println(numbers.size());
    }

    public static void permutation(int cnt) {
        if(cnt == K) {
            numbers.add(Integer.parseInt(number.toString()));
            return;
        }

        for(int i = 0; i < N; i++) {
            if(isUsed[i]) continue;
            int endIndex = number.length();
            number.append(card[i]);
            isUsed[i] = true;
            permutation(cnt+1);

            isUsed[i] = false;
            number.delete(endIndex, number.length());
        }
    }
}
