package BJ.완전탐색;

import java.util.Scanner;

public class BJ_9663_NQueen {

    static int N;
    static int[] queens;
    static int total;

    public static void findNQueen(int nth) {
        if(nth == N) {
            total++;
            return;
        }
        outer : for(int i = 0; i < N; i++) {
            for(int j = 0; j < nth; j++) {
                if(queens[j] == i || Math.abs(nth - j) == Math.abs(i - queens[j])) {
                    continue outer;
                }
            }
            queens[nth] = i;
            findNQueen(nth+1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        queens = new int[N];

        for(int i = 0; i < N/2; i++) {
            queens[0] = i;
            findNQueen(1);
        }
        if(N == 1) {
            System.out.println(1);
        } else if(N % 2 != 0) {
            int temp = total;
            queens[0] = N/2;
            findNQueen(1);
            System.out.println(total+temp);
        } else {
            System.out.println(total*2);
        }

//        findNQueen(0);
//        System.out.println(total);
    }
}
