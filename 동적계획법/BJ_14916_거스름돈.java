package BJ.동적계획법;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_14916_거스름돈 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] DP = new int[N+1];
        if(N >= 2) DP[2] = 1;
        if(N >= 5) DP[5] = 1;
        for(int i = 1; i < N+1; i++) {
            if(DP[i] == 0) {
                if(i-2 > 0 && DP[i-2] != 0) {
                    DP[i] = DP[i-2] + 1;
                }
                if(i-5 > 0 && DP[i-5] != 0) {
                    if(DP[i] == 0) DP[i] = DP[i-5] + 1;
                    else DP[i] = Math.min(DP[i], DP[i-5]+1);
                }
            }
        }
        System.out.println(DP[N] != 0 ? DP[N] : -1);
    }
}
