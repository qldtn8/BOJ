package BJ.해시;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BJ_1351_무한수열 {

    static long N;
    static int P, Q;
    static Map<Long, Long> memo;

    public static long recursive(long n) {
        if(memo.containsKey(n)) {
            return memo.get(n);
        }
        long a_i = recursive(n/P) + recursive(n/Q);
        memo.put(n, a_i);
        return a_i;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextLong();
        P = scanner.nextInt();
        Q = scanner.nextInt();

        memo = new HashMap<>();
        memo.put(0L, 1L);

        System.out.println(recursive(N));
    }
}
