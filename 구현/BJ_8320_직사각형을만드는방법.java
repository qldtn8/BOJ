package BJ.구현;

import java.util.Scanner;

public class BJ_8320_직사각형을만드는방법 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int numOf = 0;
        for(int i = 1; i <= N; i++) {
            int divisor = 0;
            for(int j = 1; j <= i; j++) {
                if(i % j == 0) {
                    divisor++;
                }
            }
            numOf += (divisor+1) / 2;
        }
        System.out.println(numOf);
    }
}
