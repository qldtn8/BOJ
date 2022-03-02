package BJ.순열조합부분집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11050_이항계수1 {

    public static int combination(int n, int r) {
        if(r == 0 || n == r) {
            return 1;
        }
        return combination(n-1, r-1) + combination(n-1, r);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int r = Integer.parseInt(token.nextToken());
        if(r > n/2) r = n-r;
        System.out.println(combination(n, r));
    }
}
