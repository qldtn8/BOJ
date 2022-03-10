package BJ.완전탐색;

import java.util.Scanner;

public class BJ_2231_분해합 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for(int i = 1; i <= N; i++) {
            if(i == N) {
                System.out.println(0);
                break;
            }
            int temp = i;
            int sum = i;
            while(true) {
                if(temp / 10 == 0) {
                    sum += temp;
                    break;
                }
                sum += temp % 10;
                temp = temp / 10;
            }
            if(sum == N) {
                System.out.println(i);
                break;
            }
        }
    }
}
