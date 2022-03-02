package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2563_색종이 {

    static int N;   // 색종이 개수
    static boolean[][] paper;   // 흰색 도화지

    public static void checkBlackPaper(int x, int y) {
        for(int r = x; r < x+10; r++) {
            for (int c = y; c < y + 10; c++) {
                if (!paper[r][c]) paper[r][c] = true;
            }
        }
    }

    public static int calculateArea() {
        int sum = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(paper[i][j]) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        paper = new boolean[100][100];
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            checkBlackPaper(x, y);
        }
        System.out.println(calculateArea());
    }
}
