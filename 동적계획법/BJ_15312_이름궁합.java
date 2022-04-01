package BJ.동적계획법;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_15312_이름궁합 {

    static int[] count = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String A = scanner.next();
        String B = scanner.next();

        ArrayList<Integer> DP = new ArrayList<>();
        for(int i = 0; i < A.length(); i++) {
            DP.add(count[A.charAt(i)-'A']);
            DP.add(count[B.charAt(i)-'A']);
        }
        for(int i = 0; i < DP.size()-2; i++) {
            for(int j = 0; j < DP.size()-1-i; j++) {
                DP.set(j, (DP.get(j)+DP.get(j+1)) % 10);
            }
        }
        System.out.println(DP.get(0) +"" +DP.get(1));
    }
}
