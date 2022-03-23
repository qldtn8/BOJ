package BJ.재귀;

import java.util.Scanner;

public class BJ_11729_하노이탑이동순서 {

    static int count = 0;

    static String hanoi(int num, int start, int end, int temp) {
        if(num == 1) {
            count++;
            return start + " " + end;
        } else {
            count++;
            return hanoi(num-1, start, temp, end)
                    +"\n"+ start + " " + end + "\n"
                    + hanoi(num-1, temp, end, start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        String str = hanoi(N, 1, 3, 2);
        System.out.println(count);
        System.out.println(str);
    }
}
