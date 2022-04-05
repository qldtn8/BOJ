package BJ.동적계획법;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_11726_2xn타일링 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] DP = new int[n+1];
        DP[0] = 1;
        DP[1] = 1;
        for(int i = 2; i <= n; i++) {
            DP[i] = (DP[i-1]+DP[i-2]) % 10007;
        }
        System.out.println(DP[n]);

    }
}
