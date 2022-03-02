package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16927_배열돌리기2 {

    static int N, M;    // 배열의 크기
    static int R;   // 회전 수
    static int[][] arr; // 배열

    public static void rotate(int rotation, int depth) {
        if(depth == Math.min(N, M) / 2) {
            return;
        }
        int cnt = rotation;
        while(cnt >= (N+M)*2-4*(2*depth+1)) {
            cnt %= (N+M)*2-4*(2*depth+1);
        }
        for(int rot = 0; rot < cnt; rot++) {
            int temp = arr[depth][depth];
            for(int c = depth; c < M-1-depth; c++) {
                arr[depth][c] = arr[depth][c+1];
            }
            for(int r = depth; r < N-1-depth; r++) {
                arr[r][M-1-depth] = arr[r+1][M-1-depth];
            }
            for(int c = M-1-depth; c > depth; c--) {
                arr[N-1-depth][c] = arr[N-1-depth][c-1];
            }
            for(int r = N-1-depth; r > depth+1; r--) {
                arr[r][depth] = arr[r-1][depth];
            }
            arr[depth+1][depth] = temp;
        }
        rotate(rotation, depth+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());
        arr = new int[N][M];
        for(int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(token.nextToken());
            }
        }
        rotate(R, 0);
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                output.append(arr[r][c] + "\t");
            }
            output.append("\n");
        }
        System.out.println(output.substring(0, output.length()-1));
    }
}
