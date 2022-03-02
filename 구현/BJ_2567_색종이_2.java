package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2567_색종이_2 {

    static int[][] paper;

    static int[][] deltas = {{-1, 0},{1, 0},{0, -1},{0, 1}};

    public static void makeArr(int row, int col) {
        for(int r = row; r < row+10; r++) {
            for(int c = col; c < col+10; c++) {
                paper[r][c] = 1;
            }
        }
    }

    public static boolean isIn(int row, int col) {
        return 0 <= row && row < 100 && 0 <= col && col < 100;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        paper = new int[100][100];

        int N = Integer.parseInt(br.readLine());
        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            makeArr(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
        }

        int total = 0;
        for(int r = 0; r < 100; r++) {
            for(int c = 0; c < 100; c++) {
                if(paper[r][c] == 1) {
                    for(int d = 0; d < deltas.length; d++) {
                        int nr = r + deltas[d][0];
                        int nc = c + deltas[d][1];
                        if(isIn(nr, nc)) {
                            if(paper[nr][nc] == 0)
                                total++;
                        } else {
                            total++;
                        }
                    }
                }
            }
        }
        System.out.println(total);
    }
}
