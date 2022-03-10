package BJ.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17276_배열돌리기 {

    static int N;
    static int[][] arr;
    static int angle;

    public static void rotation(int nth) {
        if(nth == angle/45) {
            return;
        }
        int[] temp = Arrays.copyOf(arr[N/2], N);    // 가운데행 temp에 저장.

        for(int i = 0; i < N; i++) {
            arr[N/2][i] = arr[N-1-i][i];
            arr[N-1-i][i] = arr[N-1-i][N/2];
            arr[N-1-i][N/2] = arr[N-1-i][N-1-i];
        }
        for(int i = 0; i < N; i++) {
            arr[i][i] = temp[i];
        }
        rotation(nth+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            angle = Integer.parseInt(token.nextToken()) % 360;
            if(angle < 0) angle += 360; // 전부 시계방향으로 변경

            arr = new int[N][N];
            for(int r = 0; r < N; r++) {
                token = new StringTokenizer(br.readLine());
                for(int c = 0; c < N; c++) {
                    arr[r][c] = Integer.parseInt(token.nextToken());
                }
            }

            rotation(0);

            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    output.append(arr[r][c]+" ");
                }
                output.append("\n");
            }
        }
        System.out.println(output);
    }
}
