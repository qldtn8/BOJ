package BJ.분할정복;

import java.util.Scanner;

public class BJ_14600_샤워실바닥깔기Large {

    static int K, N;
    static int tileX, tileY;
    static int[][] arr;

    static int k = 1;

    public static void fillTile(int n, int row, int col, boolean isCenter) {
        if (n == 2) {
            System.out.println(k + " " +row + " " + col);
            int count = 0;
            for(int r = row; r < row+n; r++){
                for(int c = col; c < col+n; c++){
                    if(arr[r][c] == 0) {
                        arr[r][c] = k;
                        count++;
                    }
                }
            }
            if(count == 0) return;
            k++;
            return;
        }
        int div = n/2;
        System.out.println(n + "--------------------" + isCenter);

        // 자기자신
        fillTile(div, row, col, false);

        int startR = n*(row/n);
        int startC = n*(col/n);
        if(!isCenter) {
            fillTile(div, row+div/2, col+div/2, false);
        } else {
            System.out.println("sR : " + startR + " sC " + startC );
            int midR = (startR + n + startR)/2;
            int midC = (startC + n + startC)/2;
            int nextR, nextC;
            if(row < midR) nextR = startR + n/3;
            else nextR = midR;
            if(col < midC) nextC = startC + n/3;
            else nextC = midC;
            fillTile(div, nextR, nextC, true);
        }
        for(int r = startR; r < startR+n; r+=div) {
            for(int c = startC; c < startC+n; c+=div) {
                if(r != row || c != col) {
                    fillTile(div, r, c, false);
                }
            }
        }

//        int startR = n*(row/n);
//        int startC = n*(col/n);
//        // 중간구역
//        if(isCenter) {
//            fillTile(div, n/3, n/3, false);
//        } else {
//            fillTile(div, startR+n/3, startC+n/3, false);
//        }
//        // 4구역
//        for(int r = startR; r < startR+n; r+=div) {
//            for(int c = startC; c < startC+n; c+=div) {
//                if(r != row || c != col) {
//                    fillTile(div, r, c, false);
//                }
//            }
//        }
        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        K = scanner.nextInt();
        N = (int)Math.pow(2, K);
        arr = new int[N][N];
        tileX = scanner.nextInt()-1;
        tileY = scanner.nextInt()-1;

        arr[tileX][tileY] = -1;
        System.out.println(2*(tileX /2) + " " + 2*(tileY /2));
        fillTile(N, 2*(tileX /2), 2*(tileY /2), true);
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
