package BJ;

import java.util.Scanner;

public class Factorial_10872 {

    public static int factorial(int number) {
        if(number == 1 || number == 0) {
            return 1;
        } else {
            return number * factorial(number-1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        System.out.println(factorial(number));
    }
}
