package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3109_빵집 {

    static int R, C;    // 배열 크기
    static boolean[][] arr;
    static int total;

    static int[][] deltas = {{-1, -1},{0, -1},{1, -1}};

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    public static void connectPipeline(int r, int c) {  // 현재 위치
        if(c == 0) {
            total++;
            arr[r][c] = true;
            return;
        }
        for(int d = 0; d < deltas.length; d++) {
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];
            if(isIn(nr, nc) && !arr[nr][nc]) {
                arr[r][c] = true;
                int tempTot = total;
                connectPipeline(nr, nc);
                if(total > tempTot) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        arr = new boolean[R][C];

        for(int r = 0; r < R; r++) {
            String line = br.readLine();
            for(int c = 0; c < C; c++) {
                if(line.charAt(c) == 'x') {
                    arr[r][c] = true;
                }
            }
        }
        // ----------------입력 끝------------------

        // (r, C-1)은 항상 비어있으므로 바로 호출해도 됨.
        total = 0;
        for(int r = 0; r < R; r++) {
            connectPipeline(r, C-1);
        }
        System.out.println(total);
    }
}
