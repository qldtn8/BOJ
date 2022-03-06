package BJ.백트래킹;

import java.util.Scanner;

public class BJ_15650_N과M2 {

    static int N, M;
    static StringBuilder output;

    public static void combination(int nth, int start, int flag) {
        if(nth == M) {
            for(int i = 1; i <= N; i++) {
                if((flag & 1 << i) != 0) {
                    output.append(i + " ");
                }
            }
            output.append("\n");
            return;
        }

        for(int i = start; i <= N; i++) {
            if((flag & 1 << i) == 0) {
                combination(nth+1, i+1, flag | 1 << i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        output = new StringBuilder();

        N = scanner.nextInt();
        M = scanner.nextInt();

        combination(0, 1, 0);
        System.out.println(output);
    }
}
