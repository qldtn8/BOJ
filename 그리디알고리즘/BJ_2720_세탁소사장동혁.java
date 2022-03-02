package BJ.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2720_세탁소사장동혁 {

    static int T;   // 테스트케이스
    static int[] coin = {25, 10, 5, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int chage = Integer.parseInt(br.readLine());
            for(int i = 0; i < coin.length; i++) {
                int quotient = chage / coin[i];
                output.append(quotient + " ");
                if(quotient != 0) {
                    chage %= coin[i];
                }
            }
            output.append("\n");
        }
        System.out.println(output);
    }
}
