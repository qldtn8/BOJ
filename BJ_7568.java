package BJ;

import java.util.Scanner;

public class BJ_7568 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] people = new int[N][2];
        for(int i = 0; i < N; i++) {
            people[i][0] = scanner.nextInt();
            people[i][1] = scanner.nextInt();
        }
        for(int i = 0; i < N; i++) {
            int weight = people[i][0];
            int height = people[i][1];
            int k = 0;
            for(int j = 0; j < N; j++) {
                if(i != j && (weight < people[j][0] && height < people[j][1])) {
                    k++;
                }
            }
            if(i != N-1) {
                System.out.print((k+1) + " ");
            } else {
                System.out.print((k+1));
            }
        }
    }
}
