package BJ.해시;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ_11478_서로다른부분문자열의개수 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        Set<String> set = new HashSet<>();
        for(int s = 0; s < str.length(); s++) {
            for(int e = s+1; e <= str.length(); e++) {
                set.add(str.substring(s, e));
            }
        }
        System.out.println(set.size());
    }
}
