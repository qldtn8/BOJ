package BJ;

import java.util.Scanner;

public class Fibonachi_10870 {
    public static int fibo(int index) {
        if(index <= 1) {
            return index;
        } else {
            return fibo(index-1) + fibo(index-2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        System.out.println(fibo(index));
    }
}
