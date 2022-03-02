package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16926_배열돌리기1 {

    static int N, M;    // 배열의 크기
    static int R;   // 회전 수
    static int[][] arr; // 배열

    public static void rotation(int cnt) {
        if(cnt == R) {
            return;
        }
        int[][] newArr = new int[N][M];
        int tempM = (M % 2 == 0) ? M+1 : M;
        for(int c = 0; c < (tempM-1)/2; c++) {
            for(int r = 1; r < N-2*c; r++) {
                newArr[r+c][c] = arr[r+c-1][c];
                newArr[r+c-1][M-1-c] = arr[r+c][M-1-c];
            }
        }
        for(int r = 0; r < N/2; r++) {
            for(int c = 1; c < M-2*r; c++) {
                newArr[r][r+c-1] = arr[r][r+c];
                newArr[N-1-r][r+c] = arr[N-1-r][r+c-1];
            }
        }
        arr = newArr;
        rotation(cnt+1);
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

        rotation(0);
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                output.append(arr[r][c] + " ");
            }
            output.append("\n");
        }
        System.out.println(output.substring(0, output.length()-1));
    }
}
