package BJ.분할정복;

import java.util.Scanner;

public class BJ_5904_Moo게임 {

    static int N;
    static int index;
    static String result;

    public static void mooGame(int nth) {
        if(nth == 0) {
            if(++index == N) result = "m";
            else if(++index == N) result = "o";
            else if(++index == N) result = "o";
            return;
        }

        mooGame(nth-1);
        if(result != null) return;
        if(++index == N) result = "m";
        for(int i = 0; i < nth+2; i++) {
            if(++index == N) result = "o";
        }
        if(result != null) return;
        mooGame(nth-1);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        int preIdx = 0;
        int preCount = 3;
        while(preCount < N) {
            preCount = (++preIdx + 3) + 2 * preCount;
        }
        mooGame(preIdx);
        System.out.println(result);
    }
}
