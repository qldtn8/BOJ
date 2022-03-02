package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1992_쿼드트리 {

    static int N;
    static boolean[][] arr;

    public static int isAll0or1(int diff, int row, int col) {
        boolean is0 = true;
        boolean is1 = true;
        for(int r = row; r < row+diff; r++) {
            for(int c = col; c < col+diff; c++) {
                if(arr[r][c]) {
                    is0 = false;
                } else {
                    is1 = false;
                }
            }
        }
        if(!is0 && !is1) {
            return -1;
        } else if(is0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static StringBuilder quadTree(int n, int row, int col) {
        if(n == 1) {
            return new StringBuilder(arr[row][col] ? 1 : 0);
        }
        StringBuilder result = new StringBuilder("(");
        int temp;
        if((temp = isAll0or1(n/2, row, col)) != -1) {
            result.append(temp);
        } else {
            result.append(quadTree(n/2, row, col));
        }
        if((temp = isAll0or1(n/2, row, col+n/2)) != -1) {
            result.append(temp);
        } else {
            result.append(quadTree(n/2, row, col+n/2));
        }
        if((temp = isAll0or1(n/2, row+n/2, col)) != -1) {
            result.append(temp);
        } else {
            result.append(quadTree(n/2, row+n/2, col));
        }
        if((temp = isAll0or1(n/2, row+n/2, col+n/2)) != -1) {
            result.append(temp);
        } else {
            result.append(quadTree(n/2, row+n/2, col+n/2));
        }
        return result.append(")");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                if(line.charAt(j)=='0') {
                    arr[i][j] = false;
                } else {
                    arr[i][j] = true;
                }
            }
        }
        if(isAll0or1(N, 0, 0) == -1)
            System.out.println(quadTree(N, 0, 0));
        else {
            System.out.println(arr[0][0] ? 1 : 0);
        }
    }
}
