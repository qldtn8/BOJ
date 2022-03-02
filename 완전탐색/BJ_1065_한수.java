package BJ.완전탐색;

import java.util.Scanner;

public class BJ_1065_한수 {

    static int N;
    static int total;

    public static void searchNumber(String number) {
        int diff = 0;
        for(int i = 0; i < number.length()-1; i++) {
            int a = Integer.parseInt(String.valueOf(number.charAt(i)));
            int b = Integer.parseInt(String.valueOf(number.charAt(i+1)));
            if(i == 0) {
                diff = b-a;
            } else if(diff != b-a){
                return;
            }
        }
        total++;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        total = 0;
        for(int i = 1; i <= N; i++) {
            searchNumber(String.valueOf(i));
        }
        System.out.println(total);
    }
}
