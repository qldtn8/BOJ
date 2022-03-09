package BJ.백트래킹;

import java.util.Scanner;

public class BJ_1038_감소하는수 {

    static int N;
    static int count;

    public static boolean isDecreasing(long num) {
        int pre = (int) (num % 10);
        num /= 10;
        while(num > 0) {
            int curr = (int) (num % 10);
            if(curr <= pre) {
                return false;
            }
            pre = curr;
            num /= 10;
        }
        return true;
    }

    public static void minimunDecreasingNumber() {
        count = 9;
        for(int i = 2; i <= 10; i++) {
            long num = 0;
            for(int j = i-1; j >= 0; j--) {
                num *= 10;
                num += j;
            }
            long max = 9;
            for(int j = 0; j < i-1; j++) {
                max *= 10;
                max += 8-j;
            }
            for(long j = num; j <= max; j++) {
                if(isDecreasing(j)) {
                    if(++count == N) {
                        System.out.println(j);
                        return;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        // 10보다 작은 수는 무조건 감소하는 수
        if(N < 10) {
            System.out.println(N);
            return;
        }
        if(N > 1022) {
            System.out.println(-1);
            return;
        }

        minimunDecreasingNumber();
    }
}
