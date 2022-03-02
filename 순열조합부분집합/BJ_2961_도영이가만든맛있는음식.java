package BJ.순열조합부분집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2961_도영이가만든맛있는음식 {

    static int N;
    static int[][] tasty;
    static int min;

    public static void subSet(int current, int sour, int bitter) {
        if(current == N) {
            if(sour == 1 && bitter == 0) {
                return;
            }
            if(Math.abs(sour-bitter) < min) {
                min = Math.abs(sour-bitter);
            }
            return;
        }

        subSet(current+1, sour, bitter);

        sour *= tasty[current][0];
        bitter += tasty[current][1];
        subSet(current+1, sour, bitter);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tasty = new int[N][2];

        StringTokenizer token;
        for(int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());
            tasty[n][0] = Integer.parseInt(token.nextToken());
            tasty[n][1] = Integer.parseInt(token.nextToken());
        }
        min = Integer.MAX_VALUE;
        subSet(0, 1, 0);

        System.out.println(min);
    }
}
