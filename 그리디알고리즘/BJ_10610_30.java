package BJ.그리디알고리즘;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_10610_30 {

    static String N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.next();

        boolean isPossible = false;
        int sum = 0;
        for(int i = 0; i < N.length(); i++) {
            if(N.charAt(i) == '0') {
                isPossible = true;
            } else {
                sum += Integer.parseInt(String.valueOf(N.charAt(i)));
            }
        }

        if(isPossible && sum % 3 == 0) {
            char[] temp = N.toCharArray();
            Arrays.sort(temp);
            StringBuilder output = new StringBuilder();
            for(int i = N.length()-1; i >= 0; i--) {
                output.append(temp[i]);
            }
            System.out.println(output);
        } else {
            System.out.println(-1);
        }
    }
}
