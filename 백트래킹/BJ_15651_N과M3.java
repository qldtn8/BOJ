package BJ.백트래킹;

import java.util.Scanner;

public class BJ_15651_N과M3 {

    static int N, M;
    static StringBuilder output;

    public static void dupPermutation(int nth, int[] choosed) {
        if(nth == M) {
            for(int i = 0; i < M; i++) {
                output.append(choosed[i]+" ");
            }
            output.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            choosed[nth] = i;
            dupPermutation(nth+1, choosed);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        output = new StringBuilder();

        N = scanner.nextInt();
        M = scanner.nextInt();

        dupPermutation(0, new int[M]);
        System.out.println(output);
    }
}
