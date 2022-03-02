package BJ;

import java.util.Scanner;

/**
 * 숫자의 개수
 */
public class BJ_2577 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        String result = "" + (A*B*C);

        int[] countArr = new int[10];
        for(int i = 0; i < result.length(); i++) {
            countArr[result.charAt(i) - '0']++;
        }

        for(int count : countArr) {
            System.out.println(count);
        }
    }
}
