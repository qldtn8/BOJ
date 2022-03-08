package BJ.백트래킹;

import java.util.Scanner;

public class BJ_10974_모든순열 {

    static int N;
    static StringBuilder output;

    public static void permutation(int nth, int[] choosed, int flag) {
        if(nth == N) {
            for(int data : choosed) {
                output.append(data+ " ");
            }
            output.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            if((flag & 1 << i) == 0) {
                choosed[nth] = i;
                permutation(nth+1, choosed, flag | 1 << i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        output = new StringBuilder();

        N = scanner.nextInt();
        permutation(0, new int[N], 0);
        System.out.println(output);
    }
}
