package BJ.재귀;

import java.util.Scanner;

public class BJ_1629_곱셈 {

    static int A;
    static long result;

    public static long multi(int nth) {
        if(nth == 1) {
            return A;
        }
        return result * multi(nth-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        if(B >= C) {
            B %= (C-1);
        }
        if(B == 0) {
            B = C-1;
        }
        result = A;
        System.out.println(multi(B) % C);
    }
}
