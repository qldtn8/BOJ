package BJ.순열조합부분집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_2239_스도쿠 {

    static class Position {
        int r, c;
        public Position(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static final int N = 9;
    static int[][] sudoku;
    static ArrayList<Position> list;
    static boolean success;


    public static boolean isAvailable(int r, int c, int x) {
        // 1. 가로로 확인
        for(int col = 0; col < N; col++) {
            if(col != c && sudoku[r][col] == x)
                return false;
        }

        // 2. 세로로 확인
        for(int row = 0; row < N; row++) {
            if(row != r && sudoku[row][c] == x)
                return false;
        }

        // 3. 네모로 확인
        for(int row = r/3*3; row < r/3*3 + 3; row++) {
            for(int col = c/3*3; col < c/3*3 + 3; col++) {
                if(row != r && col != c && sudoku[row][col] == x)
                    return false;
            }
        }

        return true;
    }


    public static void permutation(int nth) {
        if(nth == list.size()) {
            success = true;
            for(int[] a : sudoku) {
                for(int b : a)
                    System.out.print(b);
                System.out.println();
            }
            return;
        }

        Position p = list.get(nth);

        for(int i = 1; i <= 9; i++) {
            if(isAvailable(p.r, p.c, i)) {
                sudoku[p.r][p.c] = i;
                permutation(nth + 1);
                sudoku[p.r][p.c] = 0;
            }
            if(success) return;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sudoku = new int[N][N];
        list = new ArrayList<>();

        for(int r = 0; r < N; r++) {
            String line = br.readLine();
            for(int c = 0; c < N; c++) {
                sudoku[r][c] = line.charAt(c) - '0';
                if(sudoku[r][c] == 0) list.add(new Position(r, c));
            }
        }

        success = false;
        permutation(0);
    }
}
