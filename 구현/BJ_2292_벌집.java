package BJ.구현;

import java.util.Scanner;

public class BJ_2292_벌집 {

    static int N;

    public static int honeycomb(int depth, int start) {
        if(start <= N && N < start+6*depth) {
            return depth+1;
        }
        return honeycomb(depth+1, start+6*depth);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        System.out.println(N == 1 ? 1 : honeycomb(1, 2));
    }
}
