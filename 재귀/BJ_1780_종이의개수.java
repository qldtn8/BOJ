package BJ.재귀;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1780_종이의개수 {

    static int N;
    static int[][] arr;
    static int[] count;

    public static void recursion(int n, int row, int col) {
        int curr = arr[row][col];
        boolean isFull = true;
        for(int r = row; r < row+n; r++) {
            for(int c = col; c < col+n; c++) {
                if(arr[r][c] != curr) {
                    isFull = false;
                    break;
                }
            }
        }

        if(isFull) {
            count[1 + curr]++;
            return;
        } else {
            for(int r = row; r < row+n; r+=n/3) {
                for(int c = col; c < col+n; c+=n/3) {
                    recursion(n/3, r, c);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        count = new int[3];
        recursion(N, 0, 0);

        bw.write(count[0]+"\n" + count[1] + "\n" + count[2]);
        bw.flush();
        bw.close();
    }
}
