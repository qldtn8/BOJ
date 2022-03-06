package BJ.백트래킹;

import java.util.Scanner;

public class BJ_15652_N과M4 {

    static int N, M;
    static StringBuilder output;

    public static void combination(int nth, int start, int[] choosed) {
        if(nth == M) {
            for(int i = 0; i < choosed.length; i++) {
                output.append(choosed[i]+" ");
            }
            output.append("\n");
            return;
        }

        for(int i = start; i <= N; i++) {
            choosed[nth] = i;
            combination(nth+1, i, choosed);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        output = new StringBuilder();

        N = scanner.nextInt();
        M = scanner.nextInt();

        combination(0, 1, new int[M]);
        System.out.println(output);
    }
}
