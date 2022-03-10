package BJ.완전탐색;

import java.util.Scanner;

public class BJ_2798_블랙잭 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] card = new int[N];
        for(int i = 0; i < N; i++) {
            card[i] = scanner.nextInt();
        }

        int max = -1;
        for(int i = 0; i < N-2; i++) {
            for(int j = i+1; j < N-1; j++) {
                for(int k = j+1; k < N; k++) {
                    int sum = card[i] + card[j] + card[k];
                    if(sum <= M && sum > max) {
                        max = sum;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
