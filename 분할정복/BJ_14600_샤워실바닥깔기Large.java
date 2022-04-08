package BJ.분할정복;

import java.util.Scanner;

public class BJ_14600_샤워실바닥깔기Large {

    static int K, N;
    static int tileX, tileY;
    static int[][] arr;
    static boolean[][] visited;

    static int k = 1;
    public static void tile(int row, int col) {
        visited[row][col] = true;
        for(int r = row; r < row+2; r++) {
            for(int c = col; c < col+2; c++) {
                if(arr[r][c] == 0) {
                    arr[r][c] = k;
                }
            }
        }
        if(k == 1 && N > 2) {
            k++; tile(row/4 + 1, col/4 + 1);
            for(int r = row/4; r < row/4+4; r+=2) {
                for(int c = col/4; c < col/4+4; c+=2){
                    if(r != row || c != col) {
                        k++;
                        tile(r, c);
                    }
                }
            }
        }
    }

    public static void fillTile(int n, int row, int col) {
        if (n == 2) {
            for(int r = row; r < row+n; r++){
                for(int c = col; c < col+n; c++){
                    if(arr[r][c] == 0) arr[r][c] = k;
                }
            }
            return;
        }

        
        int startR = row/n;
        int startC = col/n;
        // 구역5
        // startR+n/2, startC+n/2
        for(int r = startR; r < N; r+=n) {
            for(int c = startC; c < N; c+=n) {

            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        K = scanner.nextInt();
        N = (int)Math.pow(2, K);
        arr = new int[N][N];
        visited = new boolean[N][N];
        tileX = scanner.nextInt()-1;
        tileY = scanner.nextInt()-1;

        arr[tileX][tileY] = -1;
        tile(2*(tileX /2), 2*(tileY /2));
        print();
    }

    public static void print() {
        for(int c = N-1; c >= 0; c--) {
            for(int r = 0; r < N; r++) {
                System.out.print(arr[r][c]+" ");
            }
            System.out.println();
        }
    }
}
