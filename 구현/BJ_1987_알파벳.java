package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1987_알파벳 {

    static int R, C;
    static char[][] arr;
    static int MAX; // 최대 칸 수

    static int[][] deltas = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    // 배열안에 있는 지
    public static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    public static void move(int r, int c, int total, int flag) {
        for(int d = 0; d < deltas.length; d++) {
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];
            // 다음으로 이동할 칸이 배열 범위 내에 있고
            // 다음으로 이동할 칸의 알파벳이 존재한 적 없으면
            if(isIn(nr, nc) && (flag & 1 << (int)(arr[nr][nc]-'A')) == 0) {
                // 다음칸 값 미리 올리고, flag도 미리 체크.
                move(nr, nc, total+1, flag | 1 << (int)(arr[nr][nc]-'A'));
            }
        }
        // 더 이상 이동할 수 없으면 최대값 수정.
        if(total > MAX) {
            MAX = total;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        arr = new char[R][C];

        for(int r = 0; r < R; r++) {
            String line = br.readLine();
            for(int c = 0; c < C; c++) {
                arr[r][c] = line.charAt(c);
            }
        }
        MAX = Integer.MIN_VALUE;
        move(0, 0,1,1 << (int)(arr[0][0]-'A'));
        System.out.println(MAX);
    }
}
