package BJ.구현;

import java.util.Scanner;

public class BJ_2635_수이어가기 {

    static int N;
    static int MAX = -1;

    public static boolean findSequence(int num2) {
        int total = 2;
        int num1 = N;
        while(true) {
            if(num1 - num2 >= 0) {
                total++;
                int temp = num1;
                num1 = num2;
                num2 = temp-num1;
            } else {
                break;
            }
        }
        if(total >= MAX) {
            MAX = total;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        int i = N;
        for(; i > 0; i--) {
            if(findSequence(i)) {
            } else {
                break;
            }
        }

        StringBuilder output = new StringBuilder();
        output.append(MAX+"\n");
        int num1 = N;
        int num2 = i+1;
        output.append(num1 + " " + num2 + " ");
        while(true) {
            if(num1 - num2 >= 0) {
                int temp = num1 - num2;
                output.append(temp +" ");
                num1 = num2;
                num2 = temp;
            } else {
                break;
            }
        }
        System.out.println(output);
    }
}
