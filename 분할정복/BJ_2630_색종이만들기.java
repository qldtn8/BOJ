package BJ.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2630_색종이만들기 {

    static int N;
    static int[][] arr;
    static int countWhite;
    static int countBlue;

    public static boolean isSame(int row, int col, int n) {
        for(int r = row; r < row+n; r++) {
            for(int c = col; c < col+n; c++) {
                if(arr[r][c] != arr[row][col])
                    return false;
            }
        }
        return true;
    }

    public static void check(int row, int col, int n) {
        if(n == 1 || isSame(row, col, n)) {
            if(arr[row][col] == 1) countBlue++;
            else countWhite++;
            return;
        }
        check(row, col, n/2);
        check(row,col+n/2, n/2);
        check(row+n/2, col, n/2);
        check(row+n/2, col+n/2, n/2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int r = 0; r < N; r++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++){
                arr[r][c] = Integer.parseInt(token.nextToken());
            }
        }
        check(0, 0, N);
        System.out.println(countWhite+"\n"+countBlue);
    }
}
