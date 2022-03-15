package BJ.그리디알고리즘;

import java.util.Scanner;

public class BJ_16953_A화살표B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int count = 0;

        while(B > A) {
            if(B % 10 == 1) {
                B /= 10;
            } else if(B % 2 == 0) {
                B /= 2;
            } else {
                break;
            }
            count++;
        }
        if(B == A) System.out.println(count+1);
        else System.out.println(-1);
    }
}
