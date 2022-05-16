package BJ.동적계획법;

import java.util.Scanner;

public class BJ_10844_쉬운계단수 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] prevDp = new int[10];
        for(int i = 1; i < 10; i++) prevDp[i] = 1;

        int[] currDp = new int[10];
        for(int n = 2; n <= N; n++) {
            currDp[0] = prevDp[1];
            for(int i = 1; i < 9; i++) currDp[i] = (prevDp[i-1]+prevDp[i+1]) % 1000000000;
            currDp[9] = prevDp[8];

            prevDp = currDp;
            currDp = new int[10];
        }
        long sum = 0;
        for(int i = 0; i < 10; i++)
            sum += prevDp[i];
        System.out.println(sum % 1000000000);
    }
}
