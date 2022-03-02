package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10157_자리배정 {

    static int C;   // 가로
    static int R;   // 세로
    static int[][] place;    // 공연장
    static int K;   // 대기 순서

    static int[][] deltas = {{1, 0},{0, 1},{-1, 0},{0, -1}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    public static void assignPlace() {
        int cnt = 0;
        int d = 0;
        int r = 0;
        int c = 0;
        while(true) {
            if(place[r][c] == 0) {
                place[r][c] = ++cnt;
                if(cnt == K) break;
            }
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];
            if(!isIn(nr, nc) || place[nr][nc] != 0) {
                d = (d+1) % 4;
                nr = r + deltas[d][0];
                nc = c + deltas[d][1];
            }
            r = nr;
            c = nc;
        }
        System.out.println((c+1) + " " + (r+1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        C = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());
        place = new int[R][C];

        K = Integer.parseInt(br.readLine());

        if(R*C < K) {
            System.out.println("0");
        } else {
            assignPlace();
        }

    }
}
