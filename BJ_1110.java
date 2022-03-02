package BJ;

import java.util.Scanner;

/**
 * 더하기 사이클
 */
public class BJ_1110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String number = "" + N;
        int count = 0;
        while(true) {
            if(number.length() < 2 && Integer.parseInt(number) < 10) {
                number = "0"+number;
            }
            int temp = Integer.parseInt(number.substring(0,1)) + Integer.parseInt(number.substring(1));
            number = number.substring(1) + temp % 10;
            count++;

            if(N == Integer.parseInt(number)) {
                break;
            }
        }
        System.out.println(count);
    }
}
