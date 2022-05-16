package BJ.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2468_안전영역 {

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        int max = 0;
        int min = 101;
        for(int r = 0; r < N; r++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(token.nextToken());
                if(max < arr[r][c]) max = arr[r][c];
                if(min > arr[r][c]) min = arr[r][c];
            }
        }


    }
}
