package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10163_색종이 {

    static int N;
    static int[][] arr;
    static int[] count;

    public static void makeArr(int n, int row, int col, int width, int height) {
        for(int r = row; r < row+width; r++) {
            for(int c = col; c < col+height; c++) {
                if(arr[r][c] != 0) {
                    count[arr[r][c]-1]--;
                }
                arr[r][c] = n;
                count[n-1]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[1001][1001];
        count = new int[N];

        StringTokenizer token;
        for(int i = 1; i <= N; i++) {
            token = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(token.nextToken());
            int col = Integer.parseInt(token.nextToken());
            int width = Integer.parseInt(token.nextToken());
            int height = Integer.parseInt(token.nextToken());
            makeArr(i, row, col, width, height);
        }

        for(int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }

    }
}
