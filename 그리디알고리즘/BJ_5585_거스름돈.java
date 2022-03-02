package BJ.그리디알고리즘;

import java.util.Scanner;

public class BJ_5585_거스름돈 {

    static int[] change = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int temp = 1000 - scanner.nextInt();
        int total = 0;
        for(int i = 0; i < change.length; i++) {
            total += temp/change[i];
            temp %= change[i];
        }

        System.out.println(total);
    }
}
