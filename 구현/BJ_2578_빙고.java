package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2578_빙고 {

    static int[][] bingo;
    static final int N = 5;
    static int totalBingo;

    public static void playBingo(int num) {
        for(int r = 0 ; r < N; r++) {
            for(int c = 0; c < N; c++)
                if(bingo[r][c] == num) {
                    bingo[r][c] = -1;
                    break;
                }
        }
    }

    public static void findBingoLine() {
        int sum = 0;
        for(int i = 0; i < N; i++) {
            boolean isParallelBingo = true;
            boolean isVerticalBingo = true;
            for(int j = 0; j < N; j++) {
                if(bingo[i][j] != -1) {
                    isParallelBingo = false;
                }
                if(bingo[j][i] != -1) {
                    isVerticalBingo = false;
                }
            }
            if(isParallelBingo) sum++;
            if(isVerticalBingo) sum++;
        }
        boolean isDiagonalBingo1 = true;
        boolean isDiagonalBingo2 = true;
        for(int i = 0; i < N; i++) {
            if(bingo[i][i] != -1) {
                isDiagonalBingo1 = false;
            }
            if(bingo[N-1-i][i] != -1) {
                isDiagonalBingo2 = false;
            }
        }
        if(isDiagonalBingo1) sum++;
        if(isDiagonalBingo2) sum++;
        totalBingo = sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        bingo = new int[N][N];

        for(int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++)
                bingo[r][c] = Integer.parseInt(token.nextToken());
        }
        totalBingo = 0;

        for(int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                int num = Integer.parseInt(token.nextToken());
                playBingo(num);
                findBingoLine();
                if(totalBingo >= 3) {
                    System.out.println((r*N + c+1));
                    return;
                }
            }
        }

    }
}
