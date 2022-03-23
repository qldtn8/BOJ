package BJ.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1074_Z {

    static int N;
    static int row, col;

    public static int visitZ(int n, int r, int c) {
        if(n == 1) {
            if(r == 0 && c == 0) return 0;
            if(r == 0 && c == 1) return 1;
            if(r == 1 && c == 0) return 2;
            if(r == 1 && c == 1) return 3;
        }
        int sum = 0;
        int temp = (int)Math.pow(2, n-1);
        int temp2 = (int)Math.pow(2, n);
        if(0 <= r && r < temp && 0 <= c && c < temp) {
            sum = visitZ(n-1, r, c);
        } else if(0 <= r && r < temp && temp <= c && c < temp2) {
            sum = temp*temp + visitZ(n-1, r, c-temp);
        } else if(temp <= r && r < temp2 && 0 <= c && c < temp) {
            sum = temp*temp*2 + visitZ(n-1, r-temp, c);
        } else {
            sum = temp*temp*3 + visitZ(n-1, r-temp, c-temp);
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        row = Integer.parseInt(token.nextToken());
        col = Integer.parseInt(token.nextToken());

        System.out.println(visitZ(N, row, col));
    }
}
