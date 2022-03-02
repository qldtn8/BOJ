package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2669_직사각형네개의합집합의면접구하기 {

    static boolean[][] area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        area = new boolean[101][101];

        StringTokenizer token;
        int sum = 0;
        for(int t = 0; t < 4; t++) {
            token = new StringTokenizer(br.readLine());
            int startR = Integer.parseInt(token.nextToken());
            int startC = Integer.parseInt(token.nextToken());
            int endR = Integer.parseInt(token.nextToken());
            int endC = Integer.parseInt(token.nextToken());

            for(int r = startR; r < endR; r++) {
                for(int c = startC; c < endC; c++) {
                    if(!area[r][c]) {
                        area[r][c] = true;
                        sum++;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
