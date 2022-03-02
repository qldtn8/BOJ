package BJ.구현;

import java.util.Scanner;

public class BJ_2999_비밀이메일 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();

        int N = message.length();
        int r = -1;
        int c = -1;
        for(int i = 1; i <= N; i++) {
            if(N % i == 0) {
                if(i <= N / i) {
                    r = i;
                    c = N/i;
                } else {
                    break;
                }
            }
        }
        int count = 0;
        char[][] arr = new char[r][c];
        for(int col = 0; col < c; col++) {
            for(int row = 0; row < r; row++) {
                arr[row][col] = message.charAt(count++);
            }
        }
        StringBuilder output = new StringBuilder();
        for(int row = 0; row < r; row++) {
            for(int col = 0; col < c; col++) {
                output.append(arr[row][col]);
            }
        }
        System.out.println(output.toString());
    }
}
